package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.idnp2024a.loginsample.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView painting1 = findViewById(R.id.painting1);
        ImageView painting2 = findViewById(R.id.painting2);
        // Agrega más ImageViews según sea necesario

        painting1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaintingDescriptionActivity.class);
                intent.putExtra("PAINTING_ID", "1");
                startActivity(intent);
            }
        });

        painting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaintingDescriptionActivity.class);
                intent.putExtra("PAINTING_ID", "2");
                startActivity(intent);
            }
        });
    }
}
