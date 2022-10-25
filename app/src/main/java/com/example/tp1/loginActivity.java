package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText username, psw, confPsw;
    Button registerButton;

    DBHelper Tp1bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AllerAlaPageConnexion();
        Tp1bd = new DBHelper(this);

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
             String user = username.getText().toString();
             String userpsw = psw.getText().toString();
             String userConfPsw = confPsw.getText().toString();

             if(user.equals("") || psw.equals("") || userConfPsw.equals("")){
                 Toast.makeText(loginActivity.this,"Tous les champs doivent etre rempli",Toast.LENGTH_SHORT).show();
             }
             else {
                 if(userpsw.equals(userConfPsw)){
                     Boolean validationUser = Tp1bd.validationUsername(user);
                     if(validationUser == false){
                         Boolean insertion = Tp1bd.insertionDansLaBd(user,userpsw);
                         if(insertion ==true){
                             Toast.makeText(loginActivity.this,"inscription complété",Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(getApplicationContext(),HomePage.class);
                             startActivity(intent);
                         }
                         else {
                             Toast.makeText(loginActivity.this,"inscription a échoué",Toast.LENGTH_SHORT).show();
                         }
                     }
                     else {
                         Toast.makeText(loginActivity.this,"utilisateur existe déja",Toast.LENGTH_SHORT).show();
                     }
                 }
                 else {
                     Toast.makeText(loginActivity.this,"password et confirmpassword ne match pas ",Toast.LENGTH_SHORT).show();
                 }
             }
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