package com.example.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.login.Galerias.GaleriaVI;
import com.idnp2024a.loginsample.R;

public class GaleriaVIFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galeria_vi, container, false);

        // Asignar datos a GaleriaVI si es necesario
        GaleriaVI galeriaVI = view.findViewById(R.id.galeriaVIView);
        // galeriaVI.setData(points); // Asigna datos a la vista si es necesario

        return view;
    }
}
