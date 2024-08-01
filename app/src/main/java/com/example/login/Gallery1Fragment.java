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

public class Gallery1Fragment extends Fragment {

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

    public Gallery1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Gallery1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Gallery1Fragment newInstance(String param1, String param2) {
        Gallery1Fragment fragment = new Gallery1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_gallery1, container, false);

        gridView = view.findViewById(R.id.gridView);

        // Crear lista de pinturas con datos de ejemplo
        paintingList = new ArrayList<>();
        paintingList.add(new Painting("Pintura 1", "Artista 1", R.drawable.galeria1pintura1));
        paintingList.add(new Painting("Pintura 2", "Artista 2", R.drawable.galeria1pintura2));
        paintingList.add(new Painting("Pintura 3", "Artista 3", R.drawable.galeria1pintura3));
        paintingList.add(new Painting("Pintura 4", "Artista 4", R.drawable.galeria1pintura4));
        paintingList.add(new Painting("Pintura 5", "Artista 5", R.drawable.galeria1pintura5));
        paintingList.add(new Painting("Pintura 6", "Artista 6", R.drawable.galeria1pintura6));
        paintingList.add(new Painting("Pintura 7", "Artista 7", R.drawable.galeria1pintura7));
        paintingList.add(new Painting("Pintura 8", "Artista 8", R.drawable.galeria1pintura8));
        paintingList.add(new Painting("Pintura 9", "Artista 9", R.drawable.galeria1pintura9));
        paintingList.add(new Painting("Pintura 10", "Artista 10", R.drawable.galeria1pintura10));
        paintingList.add(new Painting("Pintura 11", "Artista 11", R.drawable.galeria1pintura11));
        paintingList.add(new Painting("Pintura 12", "Artista 12", R.drawable.galeria1pintura12));
        paintingList.add(new Painting("Pintura 13", "Artista 13", R.drawable.galeria1pintura13));
        paintingList.add(new Painting("Pintura 14", "Artista 14", R.drawable.galeria1pintura14));
        paintingList.add(new Painting("Pintura 15", "Artista 15", R.drawable.galeria1pintura15));
        paintingList.add(new Painting("Pintura 16", "Artista 16", R.drawable.galeria1pintura16));
        paintingList.add(new Painting("Pintura 17", "Artista 17", R.drawable.galeria1pintura17));
        paintingList.add(new Painting("Pintura 18", "Artista 18", R.drawable.galeria1pintura18));
        paintingList.add(new Painting("Pintura 19", "Artista 19", R.drawable.galeria1pintura19));
        paintingList.add(new Painting("Pintura 20", "Artista 20", R.drawable.galeria1pintura20));
        paintingList.add(new Painting("Pintura 21", "Artista 21", R.drawable.galeria1pintura21));
        paintingList.add(new Painting("Pintura 22", "Artista 22", R.drawable.galeria1pintura22));
        paintingList.add(new Painting("Pintura 23", "Artista 23", R.drawable.galeria1pintura23));
        paintingList.add(new Painting("Pintura 24", "Artista 24", R.drawable.galeria1pintura24));
        paintingList.add(new Painting("Pintura 25", "Artista 25", R.drawable.galeria1pintura25));
        paintingList.add(new Painting("Pintura 26", "Artista 26", R.drawable.galeria1pintura26));
        paintingList.add(new Painting("Pintura 27", "Artista 27", R.drawable.galeria1pintura27));
        paintingList.add(new Painting("Pintura 28", "Artista 28", R.drawable.galeria1pintura28));
        paintingList.add(new Painting("Pintura 29", "Artista 29", R.drawable.galeria1pintura29));
        paintingList.add(new Painting("Pintura 30", "Artista 30", R.drawable.galeria1pintura30));
        paintingList.add(new Painting("Pintura 31", "Artista 31", R.drawable.galeria1pintura31));
        paintingList.add(new Painting("Pintura 32", "Artista 32", R.drawable.galeria1pintura32));
        paintingList.add(new Painting("Pintura 33", "Artista 33", R.drawable.galeria1pintura33));
        paintingList.add(new Painting("Pintura 34", "Artista 34", R.drawable.galeria1pintura34));
        paintingList.add(new Painting("Pintura 35", "Artista 35", R.drawable.galeria1pintura35));
        paintingList.add(new Painting("Pintura 36", "Artista 36", R.drawable.galeria1pintura36));
        paintingList.add(new Painting("Pintura 37", "Artista 37", R.drawable.galeria1pintura37));
        paintingList.add(new Painting("Pintura 38", "Artista 38", R.drawable.galeria1pintura38));
        paintingList.add(new Painting("Pintura 39", "Artista 39", R.drawable.galeria1pintura39));
        paintingList.add(new Painting("Pintura 40", "Artista 40", R.drawable.galeria1pintura40));
        paintingList.add(new Painting("Pintura 41", "Artista 41", R.drawable.galeria1pintura41));
        paintingList.add(new Painting("Pintura 42", "Artista 42", R.drawable.galeria1pintura42));
        paintingList.add(new Painting("Pintura 43", "Artista 43", R.drawable.galeria1pintura43));
        paintingList.add(new Painting("Pintura 44", "Artista 44", R.drawable.galeria1pintura44));
        paintingList.add(new Painting("Pintura 45", "Artista 45", R.drawable.galeria1pintura45));
        paintingList.add(new Painting("Pintura 46", "Artista 46", R.drawable.galeria1pintura46));
        paintingList.add(new Painting("Pintura 47", "Artista 47", R.drawable.galeria1pintura47));
        paintingList.add(new Painting("Pintura 48", "Artista 48", R.drawable.galeria1pintura48));
        paintingList.add(new Painting("Pintura 49", "Artista 49", R.drawable.galeria1pintura49));
        paintingList.add(new Painting("Pintura 50", "Artista 50", R.drawable.galeria1pintura50));
        paintingList.add(new Painting("Pintura 51", "Artista 51", R.drawable.galeria1pintura51));
        paintingList.add(new Painting("Pintura 52", "Artista 52", R.drawable.galeria1pintura52));
        paintingList.add(new Painting("Pintura 53", "Artista 53", R.drawable.galeria1pintura53));
        paintingList.add(new Painting("Pintura 54", "Artista 54", R.drawable.galeria1pintura54));
        paintingList.add(new Painting("Pintura 55", "Artista 55", R.drawable.galeria1pintura55));
        paintingList.add(new Painting("Pintura 56", "Artista 56", R.drawable.galeria1pintura56));
        paintingList.add(new Painting("Pintura 57", "Artista 57", R.drawable.galeria1pintura57));
        paintingList.add(new Painting("Pintura 58", "Artista 58", R.drawable.galeria1pintura58));
        paintingList.add(new Painting("Pintura 59", "Artista 59", R.drawable.galeria1pintura59));

        // Inicializar el adaptador con la lista de pinturas
        paintingAdapter = new PaintingAdapter(getContext(), paintingList);
        gridView.setAdapter(paintingAdapter);

        return view;
    }
}