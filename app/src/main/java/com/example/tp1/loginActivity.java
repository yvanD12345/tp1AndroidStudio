package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
    EditText username, psw, confPsw;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AllerAlaPageConnexion();

        username = (EditText) findViewById(R.id.inputPswL);
        psw = (EditText) findViewById(R.id.inputPsw);
        confPsw = (EditText) findViewById(R.id.inputConfPsw);
        InscrireUser();

    }

    protected void InscrireUser() {
        registerButton = (Button)  findViewById(R.id.buttonRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    protected void AllerAlaPageConnexion(){

        TextView button = findViewById(R.id.userAlreadyexist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,registerActivity.class));
            }
        });
    }
}