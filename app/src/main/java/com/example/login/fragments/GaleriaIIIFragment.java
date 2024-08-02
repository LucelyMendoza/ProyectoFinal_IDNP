package com.example.login.fragments;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.login.Galerias.GaleriaIII;
import com.example.login.PointRoom;
import com.idnp2024a.loginsample.R;

import java.util.ArrayList;
import java.util.List;

public class GaleriaIIIFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galeria_iii, container, false);

        GaleriaIII galeriaIIIView = view.findViewById(R.id.galeriaIIIView);

        List<PointRoom> points = new ArrayList<>();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        points.add(new PointRoom(10, 10));
        points.add(new PointRoom(1070, 10));
        points.add(new PointRoom(1070, 1800));
        points.add(new PointRoom(10, 1800));
        galeriaIIIView.setData(points);

        return view;
    }
}
