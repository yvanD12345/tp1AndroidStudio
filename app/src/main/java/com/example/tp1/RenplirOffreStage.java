package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RenplirOffreStage extends AppCompatActivity {

    EditText companyName, email, Contact, poste;
    Button bouttonPoster;
    DBHelper Tp1bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renplir_offre_stage);
        Tp1bd = new DBHelper(this);
        companyName = findViewById(R.id.companyName);
        email = findViewById(R.id.emailCompany);
        Contact =  findViewById(R.id.Contact);
        poste = findViewById(R.id.poste);
        bouttonPoster = findViewById(R.id.buttonPosterOffre);
        bouttonPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyNameEnString = companyName.getText().toString();
                String emailEnString = email.getText().toString();
                String contactEnString= Contact.getText().toString();
                String nomPosteEnString = poste.getText().toString();
                Boolean insertionReussi = Tp1bd.insertoffer(companyNameEnString,emailEnString,contactEnString,nomPosteEnString);
                if(insertionReussi == true){
                    Toast.makeText(RenplirOffreStage.this,"une nouvelle offre de stage a été postulée", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RenplirOffreStage.this,"l'offre de stage n'a pas été postuléw", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}