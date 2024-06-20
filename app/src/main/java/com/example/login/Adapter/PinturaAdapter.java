package com.example.login.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Pintura;
import com.idnp2024a.loginsample.R;

import java.util.List;

public class PinturaAdapter extends RecyclerView.Adapter<PinturaViewHolder> {
    private List<Pintura> pinturas;
    private OnItemClickListener listener;

    public PinturaAdapter(List<Pintura> pinturas, OnItemClickListener listener) {
        this.pinturas = pinturas;
        this.listener = listener;
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
        holder.bind(pintura, listener);
    }

    @Override
    public int getItemCount() {
        return pinturas.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Pintura pintura);
    }
}






