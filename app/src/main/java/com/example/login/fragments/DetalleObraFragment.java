package com.example.login.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idnp2024a.loginsample.R;

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
    private String artista;
    private String estrellas;
    private String descripcion;
    private String galeria;
    private int audioId;

    private MediaPlayer mediaPlayer;

    public DetalleObraFragment() {
        // Required empty public constructor
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

        // botón de audio
        imgAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getContext(), audioId);
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
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
}
