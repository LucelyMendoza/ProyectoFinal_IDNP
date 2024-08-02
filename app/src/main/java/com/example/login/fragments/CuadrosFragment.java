package com.example.login.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.login.Entity.Pintura;
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
        pinturas.add(new Pintura(R.drawable.galeria1pintura1, "Pintura 1", "Artista 1", "5 estrellas", "Galeria I", "Una representación divertida de un personaje histórico.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura2, "Pintura 2", "Artista 2", "4 estrellas", "Galeria I", "Caricatura que refleja un momento cómico de la vida cotidiana.", R.raw.audio2, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura3, "Pintura 3", "Artista 3", "2 estrellas", "Galeria I", "Personaje de caricatura en una situación absurda y divertida.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura4, "Pintura 4", "Artista 4", "1 estrella", "Galeria I", "Caricatura de un personaje famoso en una pose ridícula.", R.raw.audio2, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura5, "Pintura 5", "Artista 5", "3 estrellas", "Galeria I", "Representación caricaturesca de un evento histórico.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura6, "Pintura 6", "Artista 6", "5 estrellas", "Galeria I", "Escena humorística con personajes caricaturescos.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura7, "Pintura 7", "Artista 7", "4 estrellas", "Galeria I", "Personaje de caricatura en una situación cómica.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura8, "Pintura 8", "Artista 8", "2 estrellas", "Galeria I", "Caricatura de un personaje de la vida real en una pose humorística.", R.raw.audio1, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura9, "Pintura 9", "Artista 9", "3 estrellas", "Galeria I", "Situación absurda representada en caricatura.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura10, "Pintura 10", "Artista 10", "4 estrellas", "Galeria I", "Caricatura que muestra un evento cómico.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura11, "Pintura 11", "Artista 11", "5 estrellas", "Galeria I", "Personajes caricaturescos en una escena cotidiana.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura12, "Pintura 12", "Artista 12", "2 estrellas", "Galeria I", "Caricatura de un momento histórico con un toque de humor.", R.raw.audio1, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura13, "Pintura 13", "Artista 1", "3 estrellas", "Galeria I", "Escena cómica representada en caricatura.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura14, "Pintura 14", "Artista 2", "4 estrellas", "Galeria I", "Caricatura de un personaje en una situación humorística.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura15, "Pintura 15", "Artista 3", "5 estrellas", "Galeria I", "Personaje de caricatura en una escena divertida.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura16, "Pintura 16", "Artista 4", "2 estrellas", "Galeria I", "Caricatura que retrata una escena cotidiana con humor.", R.raw.audio1, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura17, "Pintura 17", "Artista 5", "3 estrellas", "Galeria I", "Momento histórico representado en caricatura.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura18, "Pintura 18", "Artista 6", "4 estrellas", "Galeria I", "Personaje de caricatura en una situación cómica.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura19, "Pintura 19", "Artista 7", "5 estrellas", "Galeria I", "Caricatura que muestra una escena cómica.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura20, "Pintura 20", "Artista 8", "2 estrellas", "Galeria I", "Personaje de caricatura en una pose humorística.", R.raw.audio1, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura21, "Pintura 21", "Artista 9", "3 estrellas", "Galeria I", "Situación absurda representada en caricatura.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura22, "Pintura 22", "Artista 10", "4 estrellas", "Galeria I", "Caricatura de un evento cómico.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura23, "Pintura 23", "Artista 11", "5 estrellas", "Galeria I", "Personajes caricaturescos en una escena cotidiana.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura24, "Pintura 24", "Artista 12", "2 estrellas", "Galeria I", "Caricatura de un momento histórico con un toque de humor.", R.raw.audio1, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura25, "Pintura 25", "Artista 1", "3 estrellas", "Galeria I", "Escena cómica representada en caricatura.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura26, "Pintura 26", "Artista 2", "4 estrellas", "Galeria I", "Caricatura de un personaje en una situación humorística.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura27, "Pintura 27", "Artista 3", "5 estrellas", "Galeria I", "Personaje de caricatura en una escena divertida.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura28, "Pintura 28", "Artista 4", "2 estrellas", "Galeria I", "Caricatura que retrata una escena cotidiana con humor.", R.raw.audio1, "Caricatura", "Autorretrato"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura29, "Pintura 29", "Artista 5", "3 estrellas", "Galeria I", "Momento histórico representado en caricatura.", R.raw.audio1, "Caricatura", "Óleo"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura30, "Pintura 30", "Artista 6", "4 estrellas", "Galeria I", "Personaje de caricatura en una situación cómica.", R.raw.audio1, "Caricatura", "Acuarela"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura31, "Pintura 31", "Artista 7", "5 estrellas", "Galeria I", "Caricatura que muestra una escena cómica.", R.raw.audio1, "Caricatura", "Colores"));
        pinturas.add(new Pintura(R.drawable.galeria1pintura32, "Pintura 32", "Artista 8", "2 estrellas", "Galeria I", "Personaje de caricatura en una pose humorística.", R.raw.audio1, "Caricatura", "Autorretrato"));

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
                showFilterOptions();
            }
            private void showFilterOptions() {
                String[] filterOptions = {"Categoría", "Técnica"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Selecciona una opción de filtro")
                        .setItems(filterOptions, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == 0) { // Categoría
                                    showCategoryOptions();
                                } else if (which == 1) { // Técnica
                                    showTechniqueOptions();
                                }
                            }
                            private void showCategoryOptions() {
                                String[] categories = {"Pintura", "Fotografía", "Manualidad", "Caricatura"};

                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setTitle("Selecciona una categoría")
                                        .setItems(categories, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                String selectedCategory = categories[which];
                                                // Filtra la lista según la categoría seleccionada
                                                filterByCategory(selectedCategory);
                                            }
                                            private void filterByCategory(String selectedCategory) {
                                                List<Pintura> filteredList = new ArrayList<>();
                                                for (Pintura pintura : pinturas) {
                                                    if (pintura.getCategoria().equalsIgnoreCase(selectedCategory)) { // Asegúrate de que tu modelo tenga un método para obtener la categoría
                                                        filteredList.add(pintura);
                                                    }
                                                }
                                                pinturaAdapter.updateList(filteredList);
                                            }

                                        });
                                builder.create().show();
                            }
                            private void showTechniqueOptions() {
                                String[] techniques = {"Autorretrato", "Óleo", "Arcilla", "Acuarela"};

                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext() );
                                builder.setTitle("Selecciona una técnica")
                                        .setItems(techniques, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                String selectedTechnique = techniques[which];
                                                // Filtra la lista según la técnica seleccionada
                                                filterByTechnique(selectedTechnique);
                                            }
                                            private void filterByTechnique(String technique) {
                                                List<Pintura> filteredList = new ArrayList<>();
                                                for (Pintura pintura : pinturas) {
                                                    if (pintura.getTecnica().equalsIgnoreCase(technique)) { // Asegúrate de que tu modelo tenga un método para obtener la técnica
                                                        filteredList.add(pintura);
                                                    }
                                                }
                                                pinturaAdapter.updateList(filteredList);
                                            }
                                        });

                                builder.create().show();
                            }

                        });

                builder.create().show();
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