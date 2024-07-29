package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.login.Room.PinturaDao;
import com.example.login.fragments.CuadrosFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Agregado 29/07
        AppDatabase db = MyApp.getInstance().getDatabase();
        PinturaDao pinturaDao = db.pinturaDao();

        // Usa el pinturaDao para interactuar con la tabla Pintura
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
