package com.example.login;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.Entity.Pintura;
import com.example.login.Room.PinturaDao;
import com.example.login.fragments.CuadrosFragment;
import com.example.login.fragments.HomeFragment;
import com.example.login.fragments.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.idnp2024a.loginsample.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment = null;
    private CuadrosFragment cuadrosFragment = null;
    private MapaFragment mapaFragment = null;

    private class InsertPinturaTask extends AsyncTask<Pintura, Void, Void> {
        @Override
        protected Void doInBackground(Pintura... pinturas) {
            PinturaDao pinturaDao = MyApp.getInstance().getDatabase().pinturaDao();
            pinturaDao.insert(pinturas[0]);
            return null;
        }
    }
    // ViewModel para manejar las operaciones de base de datos
    private PinturaViewModel pinturaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el ViewModel
        pinturaViewModel = new ViewModelProvider(this).get(PinturaViewModel.class);

        // Crear y agregar una nueva pintura a la base de datos
        Pintura nuevaPintura = new Pintura();
        nuevaPintura.setImagenId(1);
        nuevaPintura.setNombre("El Grito");
        nuevaPintura.setArtista("Edvard Munch");
        nuevaPintura.setEstrellas("5");
        nuevaPintura.setGaleria("Galería Nacional");
        nuevaPintura.setDescripcion("Una pintura famosa de Munch.");
        nuevaPintura.setAudio(1);

        pinturaViewModel.insert(nuevaPintura);
        String accountEntity = getIntent().getStringExtra("ACCOUNT");
        Log.d("MainActivity", accountEntity);

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
