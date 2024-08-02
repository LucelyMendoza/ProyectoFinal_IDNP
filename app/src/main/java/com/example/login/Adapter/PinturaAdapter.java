package com.example.login.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Entity.Pintura;
import com.idnp2024a.loginsample.R;

import java.util.List;

public class PinturaAdapter extends RecyclerView.Adapter<PinturaViewHolder> {
    private List<Pintura> pinturas;
    private OnItemClickListener itemClickListener;
    private OnAudioClickListener audioClickListener;

    public PinturaAdapter(List<Pintura> pinturas, OnItemClickListener itemClickListener, OnAudioClickListener audioClickListener) {
        this.pinturas = pinturas;
        this.itemClickListener = itemClickListener;
        this.audioClickListener = audioClickListener;
    }

    @NonNull
    @Override
    public PinturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pintura, parent, false);
        return new PinturaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PinturaViewHolder holder, int position) {
        Pintura pintura = pinturas.get(position);
        holder.bind(pintura, itemClickListener, audioClickListener);
    }

    @Override
    public int getItemCount() {
        return pinturas.size();
    }

    public void updateList(List<Pintura> filteredList) {
        pinturas = filteredList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Pintura pintura);
    }

    public interface OnAudioClickListener {
        void onAudioClick(Pintura pintura);
    }
}


