package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {

    EditText username, psw;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //methode permettant d'aller à ls psge d'inscription quand je clique sur le lien
        AllerALaPageInscription();

        username = (EditText) findViewById(R.id.inputUsernameL);
        psw = (EditText) findViewById(R.id.inputPswL);

        connecterUser();
    }

    protected void connecterUser() {
        loginButton = (Button)  findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    protected void AllerALaPageInscription(){
        TextView button = findViewById(R.id.RegisterLink);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registerActivity.this,loginActivity.class));
            }
        });
    }
}