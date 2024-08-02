package com.example.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.login.Galerias.GaleriaVIISala;
import com.idnp2024a.loginsample.R;

public class GaleriaVIISalaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galeria_vii_sala, container, false);

        // Asignar datos a GaleriaVIISala si es necesario
        GaleriaVIISala galeriaVIISala = view.findViewById(R.id.galeriaVIISalaView);
        // galeriaVIISala.setData(points); // Asigna datos a la vista si es necesario

        return view;
    }
}
