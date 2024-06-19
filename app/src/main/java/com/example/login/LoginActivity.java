package com.example.login;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.idnp2024a.loginsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    private static String TAB = "MainActivity";
    private ActivityMainBinding binding;
    private AccountEntity accountEntity;
    private String accountEntityString;
    private ActivityResultLauncher<Intent> activityResultLauncher;
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
                if (edtUsername.getText().toString().equals(accountEntity.getUsername()) && edtPassword.getText().toString().equals(accountEntity.getPassword())) {
                    // Autenticación exitosa
                    Toast.makeText(getApplicationContext(), "Autenticación exitosa", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Bienvenido a mi app");

                    Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("ACCOUNT", accountEntityString);

                    startActivity(intent);
                } else {
                    // Autenticación fallidA
                    Toast.makeText(getApplicationContext(), "Error en la autenticación", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Error en la autenticación");
                }
            }
        });

        btnAddAccount.setOnClickListener(view1 -> {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            activityResultLauncher.launch(intent);
        });

    activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    Integer resultCode = activityResult.getResultCode();
                    Log.d("LoginActivity", "resultCode: " + resultCode);
                    if(resultCode==AccountActivity.ACCOUNT_ACEPTAR){
                        Intent data = activityResult.getData();
                        accountEntityString = data.getStringExtra(AccountActivity.ACCOUNT_RECORD);

                        Gson gson = new Gson();
                        accountEntity = gson.fromJson(accountEntityString, AccountEntity.class);

                        String firstname = accountEntity.getFirstname();
                        Toast.makeText(getApplicationContext(), "Nombre:" + firstname, Toast.LENGTH_SHORT).show();
                        Log.d("LoginActivity", "Nombre: " + firstname);
                    }
                    else if(activityResult.getResultCode()==AccountActivity.ACCOUNT_CANCELAR){
                        Toast.makeText(getApplicationContext(),"Cancelado", Toast.LENGTH_SHORT).show();
                        Log.d("LoginActivity", "Cancelado");
                    }
                }
            });
    }
}


/*        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });*/
  /* Intent intent = getIntent();
        AccountEntity accountEntity = null;
        if (intent != null && intent.hasExtra("accountEntity")) {
            accountEntity = (AccountEntity) intent.getSerializableExtra("accountEntity");
        }

        // Verificar si el objeto AccountEntity no es nulo y acceder a sus campos
        if (accountEntity != null) {
            String username = accountEntity.getUsername();
            String password = accountEntity.getPassword();
        }

    }*/