package com.example.login.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Entity.Pintura;
import com.idnp2024a.loginsample.R;

public class PinturaViewHolder extends RecyclerView.ViewHolder {
    ImageView imgPintura, imgAudio;
    TextView nombre, artista, estrellas;

    public PinturaViewHolder(View view) {
        super(view);
        imgPintura = view.findViewById(R.id.imgPintura);
        nombre = view.findViewById(R.id.txtPintura);
        artista = view.findViewById(R.id.txtArtista);
        estrellas = view.findViewById(R.id.txtEstrellas);
        imgAudio = view.findViewById(R.id.imgAudio);
    }

    public void bind(final Pintura pintura, final PinturaAdapter.OnItemClickListener listener, final PinturaAdapter.OnAudioClickListener audioClickListener) {
        if (imgPintura != null) {
            imgPintura.setImageResource(pintura.getImagenId());
        }
        if (nombre != null) {
            nombre.setText(pintura.getNombre());
        }
        if (artista != null) {
            artista.setText(pintura.getArtista());
        }
        if (estrellas != null) {
            estrellas.setText(pintura.getEstrellas());
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(pintura);
                }
            }
        });

    }
}