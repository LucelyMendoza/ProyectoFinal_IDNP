package com.example.myapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.idnp2024a.loginsample.R;

public class PaintingDescriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting_description);

        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        String paintingId = getIntent().getStringExtra("PAINTING_ID");

        // Aquí irían los textos de descripción correspondientes
        String description = "";
        switch (paintingId) {
            case "1":
                description = "Descripción de la pintura 1";
                break;
            case "2":
                description = "Descripción de la pintura 2";
                break;
            // Agrega más casos según sea necesario
        }

        descriptionTextView.setText(description);
    }
}
