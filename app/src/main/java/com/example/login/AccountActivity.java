package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.idnp2024a.loginsample.databinding.ActivityAccountBinding;

public class AccountActivity extends AppCompatActivity {

    private ActivityAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Agregar OnClickListener al botón
        binding.btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener datos del formulario
                String firstname = binding.edtFirstname.getText().toString();
                String lastname = binding.edtLastname.getText().toString();
                String email = binding.edtEmail.getText().toString();
                String phone = binding.edtPhone.getText().toString();
                String username = binding.edtUsername2.getText().toString();
                String password = binding.edtPassword2.getText().toString();

                // Crear un objeto AccountEntity
                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setFirstname(firstname);
                accountEntity.setLastname(lastname);
                accountEntity.setEmail(email);
                accountEntity.setPhone(phone);
                accountEntity.setUsername(username);
                accountEntity.setPassword(password);

                // Enviar el objeto AccountEntity a LoginActivity
                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                intent.putExtra("accountEntity", accountEntity);
                startActivity(intent);
            }
        });
    }
}