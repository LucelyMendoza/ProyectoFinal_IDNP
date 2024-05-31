package com.example.login;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.idnp2024a.loginsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText edtUsername = binding.edtUsername;
        EditText edtPassword = binding.edtPassword;
        Button btnLogin = binding.btnLogin;
//        Button btnRegistro = binding.btnRegistro;
        Button btnAddAccount = binding.btnAddAccount;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().equals("Lucely") && edtPassword.getText().toString().equals("12345")) {
                    // Autenticación exitosa
                    Toast.makeText(getApplicationContext(), "Autenticación exitosa", Toast.LENGTH_SHORT).show();
                    String username = edtUsername.getText().toString();
                    // Abrir HomeActivity y pasar el valor del campo de usuario
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    // Autenticación fallidA
                    Toast.makeText(getApplicationContext(), "Error en la autenticación", Toast.LENGTH_SHORT).show();
                }
            }

        });

/*        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });*/

        btnAddAccount.setOnClickListener(view1 -> {
            Intent intent = new Intent(getApplicationContext(),AccountActivity.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        AccountEntity accountEntity = null;
        if (intent != null && intent.hasExtra("accountEntity")) {
            accountEntity = (AccountEntity) intent.getSerializableExtra("accountEntity");
        }

        // Verificar si el objeto AccountEntity no es nulo y acceder a sus campos
        if (accountEntity != null) {
            String username = accountEntity.getUsername();
            String password = accountEntity.getPassword();
        }

    }
}