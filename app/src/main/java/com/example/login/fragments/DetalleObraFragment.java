package com.example.login.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idnp2024a.loginsample.R;
import com.example.login.AudioService;

public class DetalleObraFragment extends Fragment {

    private static final String ARG_IMAGEN_ID = "imagenId";
    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_ARTISTA = "artista";
    private static final String ARG_ESTRELLAS = "estrellas";
    private static final String ARG_DESCRIPCION = "descripcion";
    private static final String ARG_GALERIA = "galeria";
    private static final String ARG_AUDIO_ID = "audioId";

    private int imagenId;
    private String nombre;
    private boolean isAudioPlaying = false;
    private String artista;
    private String estrellas;
    private String descripcion;
    private String galeria;
    private int audioId;

    private MediaPlayer mediaPlayer;

    public DetalleObraFragment() {

    }

    public static DetalleObraFragment newInstance(int imagenId, String nombre, String artista, String estrellas, String galeria, String descripcion, int audioId) {
        DetalleObraFragment fragment = new DetalleObraFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGEN_ID, imagenId);
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_ARTISTA, artista);
        args.putString(ARG_ESTRELLAS, estrellas);
        args.putString(ARG_DESCRIPCION, descripcion);
        args.putString(ARG_GALERIA, galeria);
        args.putInt(ARG_AUDIO_ID, audioId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imagenId = getArguments().getInt(ARG_IMAGEN_ID);
            nombre = getArguments().getString(ARG_NOMBRE);
            artista = getArguments().getString(ARG_ARTISTA);
            estrellas = getArguments().getString(ARG_ESTRELLAS);
            descripcion = getArguments().getString((ARG_DESCRIPCION));
            galeria = getArguments().getString((ARG_GALERIA));
            audioId = getArguments().getInt(ARG_AUDIO_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_obra, container, false);

        ImageView imgDetalle = view.findViewById(R.id.imgPintura);
        TextView txtNombre = view.findViewById(R.id.textTituloPintura);
        TextView txtGaleria = view.findViewById(R.id.textGaleria);
        TextView txtDescripcion = view.findViewById(R.id.textDescripcion);
        ImageView imgBack = view.findViewById(R.id.imgBack);
        ImageView imgAudio = view.findViewById(R.id.imgAudio);

        imgDetalle.setImageResource(imagenId);
        txtNombre.setText(nombre);
        txtDescripcion.setText(descripcion);
        txtGaleria.setText(galeria);

        // Botón back
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.popBackStack();
            }
        });


        //  Botón de audio
        //  Botón de audio
        imgAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getActivity(), AudioService.class);

                // Cambia el estado del audio y el comando según corresponda
                if (isAudioPlaying) {
                    serviceIntent.putExtra(AudioService.COMMAND, AudioService.PAUSE); // Enviar comando de pausa
                    imgAudio.setImageResource(R.drawable.iconoaudio); // Cambia el icono a "play"
                    isAudioPlaying = false; // Actualiza el estado
                } else {
                    serviceIntent.putExtra(AudioService.COMMAND, AudioService.PLAY); // Enviar comando de reproducción
                    serviceIntent.putExtra(AudioService.TEXT, descripcion); // Envía la descripción al servicio
                    imgAudio.setImageResource(R.drawable.pause_icon); // Cambia el icono a "pause"
                    isAudioPlaying = true; // Actualiza el estado
                }

                getActivity().startService(serviceIntent);
            }
        });


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        // Inicia el servicio en primer plano solo si el fragmento ya no es visible
        Intent serviceIntent = new Intent(getActivity(), AudioService.class);
        serviceIntent.putExtra(AudioService.COMMAND, AudioService.START_FOREGROUND);

        // Asegúrate de que el audioId se convierte a un nombre de archivo adecuado, si es necesario
        String filename = "audio_" + R.raw.audio1; // Cambia esto según cómo estés almacenando los archivos de audio
        serviceIntent.putExtra(AudioService.FILENAME, filename); // Asegúrate de que el nombre del archivo no sea nulo

        Log.d("DetalleObraFragment", "onStop - Command: " + AudioService.START_FOREGROUND);
        Log.d("DetalleObraFragment", "onStop - Filename: " + filename);

        getActivity().startService(serviceIntent);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Detén el servicio de primer plano cuando el usuario vuelve a la aplicación
        Intent serviceIntent = new Intent(getActivity(), AudioService.class);
        serviceIntent.putExtra(AudioService.COMMAND, AudioService.STOP_FOREGROUND);

        Log.d("DetalleObraFragment", "onResume - Command: " + AudioService.STOP_FOREGROUND);

        getActivity().startService(serviceIntent);
    }

}
