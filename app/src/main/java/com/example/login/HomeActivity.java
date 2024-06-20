package com.example.login;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.login.fragments.CuadrosFragment;
import com.example.login.fragments.DetalleObraFragment;
import com.example.login.fragments.HomeFragment;
import com.example.login.fragments.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.idnp2024a.loginsample.R;

public class HomeActivity extends AppCompatActivity {
    private FragmentManager fragmentManager= null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment=null;
    private CuadrosFragment cuadrosFragment = null;
    private DetalleObraFragment detalleObraFragment = null;
    private MapaFragment mapaFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(v, insets)->{
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(SystemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        String accountEntity= getIntent().getStringExtra("ACCOUNT");
            Log.d("HomeActivity", accountEntity);

            //Cargar fragmentos
        fragmentManager=getSupportFragmentManager();
            //botònd e navegaciònn
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        //para cada botón -> su evento
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.menu_home){
                    homeFragment= HomeFragment.newInstance("","");
                    loadFragment(homeFragment);
                    return true;
                //Con el fin de probar
                /*if(menuItem.getItemId()==R.id.menu_home){
                    detalleObraFragment= DetalleObraFragment.newInstance("","");
                    loadFragment(detalleObraFragment);
                    return true;*/
                }else if(menuItem.getItemId()==R.id.menu_cuadros){
                    cuadrosFragment= CuadrosFragment.newInstance("","");
                    loadFragment(cuadrosFragment);
                    return true;
                }else if(menuItem.getItemId()==R.id.menu_mapas){
                    mapaFragment= MapaFragment.newInstance("","");
                    loadFragment(mapaFragment);
                    return true;
                }else{
                    return false;
                }

            }
        });
    }
    //método create para cargar los fragmentos
    private void loadFragment(Fragment fragment){
        if(fragmentManager!=null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmentTransaction.commit();
        }
    }

}