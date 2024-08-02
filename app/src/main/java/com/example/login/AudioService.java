package com.example.login;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.idnp2024a.loginsample.R;

import java.util.List;
import java.util.Locale;

public class AudioService extends Service {

    public static final String COMMAND = "COMMAND";
    public static final String FILENAME = "FILENAME";
    public static final String TEXT = "TEXT"; // Nueva constante para texto
    public static final String PLAY = "PLAY";
    public static final String PAUSE = "PAUSE";
    public static final String RESUME = "RESUME";
    public static final String STOP = "STOP";
    public static final String START_FOREGROUND = "START_FOREGROUND";
    public static final String STOP_FOREGROUND = "STOP_FOREGROUND";

    private MediaPlayer mediaPlayer;
    private TextToSpeech textToSpeech; // Añadir TextToSpeech
    private boolean isPaused = false;
    private boolean isTtsReady = false;

    private int currentFile = -1;

    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        AudioService getService() {
            return AudioService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();

        // Inicializa TextToSpeech
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    isTtsReady = true; // Marca TTS como listo
                    int result = textToSpeech.setLanguage(new Locale("es", "ES"));
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("AudioService", "Spanish language not supported");
                    }

                    // Verifica si el idioma es compatible
                    } else {
                        // Opcional: Puedes establecer una voz específica en español
                        List<Voice> voices = (List<Voice>) textToSpeech.getVoices();
                        for (Voice voice : voices) {
                            if (voice.getLocale().getLanguage().equals("es")) {
                                textToSpeech.setVoice(voice); // Establece una voz en español si está disponible
                                break;
                            }
                        }
                    }
                    textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String utteranceId) {
                            Log.d("AudioService", "Speech started");
                        }

                        @Override
                        public void onDone(String utteranceId) {
                            Log.d("AudioService", "Speech done");
                            stopForeground(true); // Eliminar la notificación cuando termine
                            stopSelf(); // Detener el servicio
                        }

                        @Override
                        public void onError(String utteranceId) {
                            Log.e("AudioService", "Speech error");
                            stopForeground(true);
                            stopSelf();
                        }
                    });
                }

        });
}


    private String currentText; // Variable para almacenar el texto actual

    private void speak(String text) {
        if (text != null && !text.isEmpty() && isTtsReady) { // Verifica si TTS está listo
            currentText = text;
            startForegroundService();
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts_utterance_id");
        } else {
            Log.e("AudioService", "TTS not ready or text is empty");
        }
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            handleCommand(intent);
        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private void handleCommand(Intent intent) {
        String command = intent.getStringExtra(COMMAND);
        int audioId = intent.getIntExtra(FILENAME, -1);
        String text = intent.getStringExtra(TEXT); // Obtener el texto

        Log.d("AudioService", "Received command: " + command);
        Log.d("AudioService", "Filename: " + audioId);
        Log.d("AudioService", "Text: " + text);

        if (command == null || (command.equals(PLAY) && audioId == -1 && text == null)) {
            Log.e("AudioService", "Received command is null or filename and text are null");
            return;
        }

        switch (command) {
            case PLAY:
                if (audioId != -1) {
                    startPlayback(audioId);
                } else if (text != null) {
                    speak(text); // Usar TextToSpeech si hay texto
                }
                break;
            case PAUSE:
                pausePlayback(); // Llama a la función de pausa
                break;
            case RESUME:
                resumePlayback(); // Si decides implementar reanudar
                break;
            case STOP:
                stopPlayback();
                break;
            case START_FOREGROUND:
                startForegroundService();
                break;
            case STOP_FOREGROUND:
                stopForeground(true);
                break;
        }
    }



    private void startPlayback(int audioId) {
        try {
            mediaPlayer.reset();
            AssetFileDescriptor afd = getResources().openRawResourceFd(audioId);
            if (afd != null) {
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(MediaPlayer::start);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pausePlayback() {
        if (textToSpeech != null && textToSpeech.isSpeaking()) {
            textToSpeech.stop(); // Detiene el habla de TTS si está hablando
        }
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause(); // Pausa el MediaPlayer
            isPaused = true; // Marca como pausado
        }
    }

    private void resumePlayback() {
        if (mediaPlayer != null && isPaused) {
            mediaPlayer.start(); // Reanuda la reproducción de audio
            isPaused = false; // Cambia el estado de pausa a falso
        } else if (textToSpeech != null && !textToSpeech.isSpeaking()) {
            textToSpeech.speak(currentText, TextToSpeech.QUEUE_FLUSH, null, "tts_utterance_id"); // Reanuda el habla
        }
    }


    private void stopPlayback() {
        mediaPlayer.stop();
        mediaPlayer.reset();
        isPaused = false;
        currentFile = -1;
    }

    private void startForegroundService() {
        NotificationHelper.createNotificationChannel(this);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                notificationIntent,
                PendingIntent.FLAG_IMMUTABLE
        );

        Notification notification = new NotificationCompat.Builder(this, NotificationHelper.CHANNEL_ID)
                .setContentTitle("Reproduciendo Audio")
                .setContentText("Reproduciendo...") // Actualiza el texto de la notificación
                .setSmallIcon(R.drawable.music_icon)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        startForeground(NotificationHelper.NOTIFICATION_ID, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
