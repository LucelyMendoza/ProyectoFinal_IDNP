package com.example.login;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.Entity.Autor;
import com.example.login.Entity.Galeria;
import com.example.login.Entity.Pintura;
import com.example.login.Room.AutorDao;
import com.example.login.Room.GaleriaDao;
import com.example.login.Room.PinturaDao;
import com.example.login.fragments.CuadrosFragment;
import com.example.login.fragments.DetalleObraFragment;
import com.example.login.fragments.HomeFragment;
import com.example.login.fragments.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.idnp2024a.loginsample.R;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment = null;
    private CuadrosFragment cuadrosFragment = null;
    private MapaFragment mapaFragment = null;

    private class InsertPinturaTask extends AsyncTask<Pintura, Void, Void> {
        private PinturaDao pinturaDao;
        private AutorDao autorDao;
        private GaleriaDao galeriaDao;
        private void InsertPinturaAsyncTask(PinturaDao pinturaDao, AutorDao autorDao, GaleriaDao galeriaDao) {
            this.pinturaDao = pinturaDao;
            this.autorDao = autorDao;
            this.galeriaDao = galeriaDao;
        }
        @Override
        protected Void doInBackground(Pintura... pinturas) {
            Log.d("PinturaViewModel", "Inserting pintura in background...");
            Pintura pintura = pinturas[0];
            Autor autor = autorDao.getByName(pintura.getArtista());
            Galeria galeria = galeriaDao.getByName(pintura.getGaleria());

            if (autor != null && galeria != null) {
                pinturaDao.insert(pintura);
            } else {
                Log.e("PinturaViewModel", "Foreign key constraint failed: autor or galeria does not exist.");
            }
            return null;
        }
    }
    // ViewModel para manejar las operaciones de base de datos
    private PinturaViewModel pinturaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinturaViewModel = new ViewModelProvider(this).get(PinturaViewModel.class);

        // Insertar datos de prueba de manera asincrónica
        new Thread(() -> {
            Autor autor = new Autor();
            autor.setNombre("Camilo Cabello");
            pinturaViewModel.insertAutor(autor);

            Galeria galeria = new Galeria();
            galeria.setNombre("Galería I");
            pinturaViewModel.insertGaleria(galeria);

            runOnUiThread(() -> {
                // Crear una nueva pintura
                Pintura pintura = new Pintura();
                pintura.setNombre("Una caricatura");
                pintura.setDescripcion("Una pintura famosa de Munch.");
                pintura.setCategoria("Categoria");
                pintura.setTecnica("Acuarela");
                pintura.setImagenId(2);
                pintura.setEstrellas("cinco");
                pintura.setAudio(2);

                // Asegúrate de que el Autor y Galería estén en la BD antes de usar sus IDs
                new Handler().postDelayed(() -> {
                    pintura.setAutorId(autor.getId());  // Asigna el ID correcto
                    pintura.setGaleriaId(galeria.getId()); // Asigna el ID correcto
                    pinturaViewModel.insert(pintura);
                }, 1000);
            });
        }).start();

        // Cargar fragmentos
        fragmentManager = getSupportFragmentManager();

        // Botón de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Para cada botón -> su evento
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home) {
                    homeFragment = HomeFragment.newInstance("", "");
                    loadFragment(homeFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.search) {
                    cuadrosFragment = CuadrosFragment.newInstance("", "");
                    loadFragment(cuadrosFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.map) {
                    mapaFragment = MapaFragment.newInstance("", "");
                    loadFragment(mapaFragment);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    // Método para cargar los fragmentos
    private void loadFragment(Fragment fragment) {
        if (fragmentManager != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmentTransaction.commit();
        }
    }


}
