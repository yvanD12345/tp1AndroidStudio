package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    EditText username, psw;
    Button loginButton;
    TextView testPost;
    DBHelper Tp1bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //methode permettant d'aller à ls psge d'inscription quand je clique sur le lien
        AllerALaPageInscription();
        AllerAlaPagePostOffer();
        username = (EditText) findViewById(R.id.inputUsernameL);
        psw = (EditText) findViewById(R.id.inputPswL);
        Tp1bd = new DBHelper(this);
        connecterUser();
    }

    protected void connecterUser() {
        loginButton = (Button)  findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String user = username.getText().toString();
             String userPsw = psw.getText().toString();

             if(user.equals("") || userPsw.equals("")){
                 Toast.makeText(registerActivity.this,"un ou plusieurs champs sont vides. Veuillez les remplir", Toast.LENGTH_SHORT).show();
             }
             else {
                 Boolean checkuserpass = Tp1bd.validationUserPsw(user,userPsw);
                 if(checkuserpass == true){
                     Toast.makeText(registerActivity.this,"connexion reussi",Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(getApplicationContext(),HomePage.class);
                     startActivity(intent);
                 }
                 else{
                     Toast.makeText(registerActivity.this,"mot de passe invalide",Toast.LENGTH_SHORT).show();
                 }
             }
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
    private void AllerAlaPagePostOffer() {
        testPost = findViewById(R.id.testpost);
        testPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registerActivity.this,RenplirOffreStage.class));
            }
        });
    }
}