package com.example.loginsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccountActivity extends AppCompatActivity {

    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtCorreo;
    private EditText edtTelefono;
    private EditText edtusuario;
    private EditText edtcontraseña;

    // Otros EditTexts para el correo electrónico, teléfono, etc.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        edtFirstName = findViewById(R.id.edtFirstname);
        edtLastName = findViewById(R.id.edtLastname);
        edtCorreo = findViewById(R.id.edtemail);
        edtTelefono = findViewById(R.id.edtphone);
        edtusuario = findViewById(R.id.edtusername2);
        edtcontraseña = findViewById(R.id.edtpassword);





        Button btnSubmit = findViewById(R.id.btnOK);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setFirstname(edtFirstName.getText().toString());
                accountEntity.setLastname(edtLastName.getText().toString());
                accountEntity.setLastname(edtCorreo.getText().toString());
                accountEntity.setLastname(edtTelefono.getText().toString());
                accountEntity.setLastname(edtusuario.getText().toString());
                accountEntity.setLastname(edtcontraseña.getText().toString());

                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                intent.putExtra("account_entity", (CharSequence) accountEntity);
                startActivity(intent);
            }
        });
    }
}
