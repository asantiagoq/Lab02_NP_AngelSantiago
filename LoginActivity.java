package com.example.loginsample;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        EditText edtUsername = binding.editUserName;
        EditText edtPassword = binding.editPassword;
        Button btnLogin = binding.btnLogin;
        Button btnAddAccount = binding.btnAddAccount;


        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")){
                    String username = edtUsername.getText().toString();

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error en la autenticacion", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Error en la autenticacion");
                }
            }

        });

        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AccountActivity.class);
                startActivity(intent);
            }
        });

        if (getIntent().hasExtra("account_entity")) {
            AccountEntity accountEntity = (AccountEntity) getIntent().getSerializableExtra("account_entity");

            String firstName = accountEntity.getFirstname();
            String lastName = accountEntity.getLastname();
            String correo = accountEntity.getEmail();
            String telefono = accountEntity.getPhone();
            String usuario = accountEntity.getUsername();
            String contraseña = accountEntity.getPassword();
        }



    }
}