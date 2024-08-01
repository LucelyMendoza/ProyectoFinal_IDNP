package com.example.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.idnp2024a.loginsample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Gallery3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Gallery3Fragment extends Fragment {
    private GridView gridView;
    private PaintingAdapter paintingAdapter;
    private List<Painting> paintingList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Gallery3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Gallery3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Gallery3Fragment newInstance(String param1, String param2) {
        Gallery3Fragment fragment = new Gallery3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery3, container, false);

        gridView = view.findViewById(R.id.gridView);

        // Crear lista de pinturas con datos de ejemplo
        paintingList = new ArrayList<>();
        paintingList.add(new Painting("Pintura 1", "Artista 1", R.drawable.galeria3pintura1));
        paintingList.add(new Painting("Pintura 2", "Artista 2", R.drawable.galeria3pintura2));
        paintingList.add(new Painting("Pintura 3", "Artista 3", R.drawable.galeria3pintura3));
        paintingList.add(new Painting("Pintura 4", "Artista 4", R.drawable.galeria3pintura4));
        paintingList.add(new Painting("Pintura 5", "Artista 5", R.drawable.galeria3pintura5));
        paintingList.add(new Painting("Pintura 6", "Artista 6", R.drawable.galeria3pintura6));
        paintingList.add(new Painting("Pintura 7", "Artista 7", R.drawable.galeria3pintura7));
        paintingList.add(new Painting("Pintura 8", "Artista 8", R.drawable.galeria3pintura8));
        paintingList.add(new Painting("Pintura 9", "Artista 9", R.drawable.galeria3pintura9));
        paintingList.add(new Painting("Pintura 10", "Artista 10", R.drawable.galeria3pintura10));
        paintingList.add(new Painting("Pintura 11", "Artista 11", R.drawable.galeria3pintura11));
        paintingList.add(new Painting("Pintura 12", "Artista 12", R.drawable.galeria3pintura12));
        paintingList.add(new Painting("Pintura 13", "Artista 13", R.drawable.galeria3pintura13));
        paintingList.add(new Painting("Pintura 14", "Artista 14", R.drawable.galeria3pintura14));
        paintingList.add(new Painting("Pintura 15", "Artista 15", R.drawable.galeria3pintura15));
        paintingList.add(new Painting("Pintura 16", "Artista 16", R.drawable.galeria3pintura16));
        paintingList.add(new Painting("Pintura 17", "Artista 17", R.drawable.galeria3pintura17));
        paintingList.add(new Painting("Pintura 18", "Artista 18", R.drawable.galeria3pintura18));

        // Inicializar el adaptador con la lista de pinturas
        paintingAdapter = new PaintingAdapter(getContext(), paintingList);
        gridView.setAdapter(paintingAdapter);

        return view;
    }
}