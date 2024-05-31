package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.idnp2024a.loginsample.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Recuperar el valor del campo de usuario del Intent
        Intent intent = getIntent();
        if (intent != null && ((Intent) intent).hasExtra("username")) {
            String username = intent.getStringExtra("username");

            // Mostrar el valor en el diseño
            TextView txtWelcomeMessage = findViewById(R.id.textView3);
            txtWelcomeMessage.setText("Bienvenido " + username);
        }
    }

}