package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.idnp2024a.loginsample.R;

public class AccountActivity extends AppCompatActivity {
    public final static String ACCOUNT_RECORD = "ACCOUNT_RECORD";
    public final static Integer ACCOUNT_ACEPTAR= 100;
    public final static Integer ACCOUNT_CANCELAR= 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        Button btnAceptar = findViewById(R.id.btnAceptar);
        Button btnCancelar = findViewById(R.id.btnCancel);

        EditText edtFirstName = findViewById(R.id.edtFirstname);
        EditText edtLastName = findViewById(R.id.edtLastname);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPhone = findViewById(R.id.edtPhone);
        EditText edtUsername2 = findViewById(R.id.edtUsername2);
        EditText edtPassword2 = findViewById(R.id.edtPassword2);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setFirstname(edtFirstName.getText().toString());
                accountEntity.setLastname(edtLastName.getText().toString());
                accountEntity.setEmail(edtEmail.getText().toString());
                accountEntity.setPhone(edtPhone.getText().toString());
                accountEntity.setUsername(edtUsername2.getText().toString());
                accountEntity.setPassword(edtPassword2.getText().toString());

                Gson gson = new Gson();
                String accountJson = gson.toJson(accountEntity);

                Intent data = new Intent();
                data.putExtra(ACCOUNT_RECORD, accountJson);

                setResult(ACCOUNT_ACEPTAR, data);
                finish();

            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(ACCOUNT_CANCELAR);
                finish();
            }
        });
    }
}
        /*// Agregar OnClickListener al botón
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
            }*/