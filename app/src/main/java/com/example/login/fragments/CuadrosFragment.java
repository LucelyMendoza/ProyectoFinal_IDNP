package com.example.login.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Adapter.PinturaAdapter;
import com.example.login.Pintura;
import com.idnp2024a.loginsample.R;

import java.util.ArrayList;
import java.util.List;

public class CuadrosFragment extends Fragment {
    private List<Pintura> pinturas;
    private FragmentManager fragmentManager;
    private MediaPlayer mediaPlayer;

    private PinturaAdapter.OnItemClickListener listener = new PinturaAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Pintura pintura) {
            //Toast.makeText(getContext(), "Clic en: " + pintura.getNombre(), Toast.LENGTH_SHORT).show();
            DetalleObraFragment detalleObraFragment = DetalleObraFragment.newInstance(
                    pintura.getImagenId(),
                    pintura.getNombre(),
                    pintura.getArtista(),
                    pintura.getEstrellas(),
                    pintura.getGaleria(),
                    pintura.getDescripcion(),
                    pintura.getAudio()
            );
            loadFragment(detalleObraFragment);
        }
    };

    private PinturaAdapter.OnAudioClickListener audioListener = new PinturaAdapter.OnAudioClickListener() {
        @Override
        public void onAudioClick(Pintura pintura) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }

            mediaPlayer = MediaPlayer.create(getContext(), pintura.getAudio());
            mediaPlayer.start();
        }
    };

    public static CuadrosFragment newInstance(String param1, String param2) {
        CuadrosFragment fragment = new CuadrosFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }


    private void loadFragment(Fragment fragment) {
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public CuadrosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        pinturas = new ArrayList<>();
        pinturas.add(new Pintura(R.drawable.obra1, "Pintura 1", "Artista 1", "5 estrellas", "Galeria IV", "Arte abstracto a base de oleos sobre un lienzo.", R.raw.audio1));
        pinturas.add(new Pintura(R.drawable.obra2, "Pintura 2", "Artista 2", "4 estrellas", "Galeria II", "Pintura en lienzo, técnica de acuarelas, y representando un lugar conocido de la ciudad de Arequipa.", R.raw.audio2));
        pinturas.add(new Pintura(R.drawable.obra3, "Pintura 3", "Artista 3", "2 estrellas", "Galeria III", "Fotografía en estilo autorretrato, en Arequipa.", R.raw.audio1));
        pinturas.add(new Pintura(R.drawable.obra4, "Pintura 4", "Artista 4", "1 estrella", "Galeria II", "Fotografía de una costumbre peruana, en la ciudad de Cusco.", R.raw.audio1));
        pinturas.add(new Pintura(R.drawable.obra5, "Pintura 5", "Artista 5", "1 estrella", "Galeria I", "Caricatura en homenaje a un artista experto en caricaturas.", R.raw.audio1));
        pinturas.add(new Pintura(R.drawable.obra6, "Pintura 6", "Artista 1", "5 estrellas", "Galeria IV", "Arte abstracto a base de oleos sobre un lienzo.", R.raw.audio1));
        pinturas.add(new Pintura(R.drawable.obra7, "Pintura 7", "Artista 4", "4 estrellas", "Galeria II", "Fotografía del traje típico que se usa en una costumbre peruana, en la ciudad de Cusco.", R.raw.audio1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuadros, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.pinturasRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        PinturaAdapter pinturaAdapter = new PinturaAdapter(pinturas, listener, audioListener);
        recyclerView.setAdapter(pinturaAdapter);

        fragmentManager = getParentFragmentManager();
        // botón back
        ImageView imgFlecha = view.findViewById(R.id.imgFlecha);
        imgFlecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        // Para realizar el filtro
        ImageView imgFiltro = view.findViewById(R.id.imgFiltro);
        imgFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FALTA IMPLEMENTAR
                Toast.makeText(getContext(), "Filtrar", Toast.LENGTH_SHORT).show();
            }
        });

        // Buscador
        EditText edtBuscador = view.findViewById(R.id.edtBuscador);
        edtBuscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String query = charSequence.toString().toLowerCase();
                List<Pintura> filteredList = new ArrayList<>();
                for (Pintura pintura : pinturas) {
                    if (pintura.getNombre().toLowerCase().contains(query) ||
                            pintura.getArtista().toLowerCase().contains(query)) {
                        filteredList.add(pintura);
                    }
                }
                PinturaAdapter pinturaAdapter = new PinturaAdapter(filteredList, listener, audioListener);
                recyclerView.setAdapter(pinturaAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {
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
