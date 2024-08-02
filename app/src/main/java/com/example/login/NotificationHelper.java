package com.example.login;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.idnp2024a.loginsample.R;

public class NotificationHelper {
    public static final String CHANNEL_ID = "AudioPlayServiceChannel";
    public static final int NOTIFICATION_ID = 1;

    // Crear canal de notificación si se está ejecutando en Android Oreo o superior
    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Audio Play Service Channel",
                    NotificationManager.IMPORTANCE_LOW
            );
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }

    // Crear la notificación para la reproducción de audio
    public static NotificationCompat.Builder createNotification(Context context, String filename, int audioId) {
        // Asegúrate de que `filename` sea el nombre correcto del recurso
        String displayText = audioId != -1 ? "Reproduciendo: " + context.getResources().getResourceEntryName(audioId) : "Reproduciendo audio desconocido";

        Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.putExtra("AUDIO_ID", audioId); // Pasar el ID de audio
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                notificationIntent,
                PendingIntent.FLAG_IMMUTABLE
        );

        return new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Reproduciendo Audio")
                .setContentText(displayText)
                .setSmallIcon(R.drawable.music_icon)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .addAction(createPauseAction(context));
    }


    // Crear acción de pausa para la notificación
    private static NotificationCompat.Action createPauseAction(Context context) {
        Intent pauseIntent = new Intent(context, AudioService.class);
        pauseIntent.setAction(AudioService.STOP);
        PendingIntent pendingPauseIntent = PendingIntent.getService(
                context, 0, pauseIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        return new NotificationCompat.Action.Builder(
                android.R.drawable.ic_media_pause,
                "Pausar",
                pendingPauseIntent
        ).build();
    }

    // Eliminar la notificación cuando se detenga la reproducción
    public static void cancelNotification(Context context) {
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.cancel(NOTIFICATION_ID);
        }
    }
}
