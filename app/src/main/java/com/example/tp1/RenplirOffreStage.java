package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RenplirOffreStage extends AppCompatActivity {


    EditText companyName,email,Contact,poste,ville,numeroDeRue,nomRue,telephone,url,postalCode;
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
        ville = findViewById(R.id.ville);
        numeroDeRue = findViewById(R.id.numeroRue);
        nomRue = findViewById(R.id.nomRue);
        url = findViewById(R.id.url);
        telephone = findViewById(R.id.editTextPhone);
        postalCode = findViewById(R.id.postalCode);
        ville = findViewById(R.id.ville);

        bouttonPoster = findViewById(R.id.buttonPosterOffre);
        bouttonPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyNameEnString = companyName.getText().toString();
                String emailEnString = email.getText().toString();
                String contactEnString= Contact.getText().toString();
                String nomPosteEnString = poste.getText().toString();

                String sVille= ville.getText().toString();
                String sAdresse = concatenationAdresse();

                String sUrl = checkUrl();

                String sTelephonee= telephone.getText().toString();
                String sPostalCode = postalCode.getText().toString();
                if(sUrl.equals("") || sAdresse.equals("")) {

                    Toast.makeText(RenplirOffreStage.this, "l'offre de stage n'a pas été postuléw", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean insertionReussi = Tp1bd.insertoffer(companyNameEnString, emailEnString, contactEnString, nomPosteEnString, sVille, sPostalCode, sAdresse, sTelephonee,sUrl);
                    if (insertionReussi == true) {
                        Toast.makeText(RenplirOffreStage.this, "une nouvelle offre de stage a été postulée", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RenplirOffreStage.this, "l'offre de stage n'a pas été postuléw", Toast.LENGTH_SHORT).show();
                    }

                }
            }
            public String concatenationAdresse(){
               String checkNumAdresse = extractNumber(numeroDeRue.getText().toString());
               if(!checkNumAdresse.equals("")){
                   String adresse = numeroDeRue.getText().toString()+" "+ nomRue.getText().toString()+" "+ville.getText().toString();
               }
              return checkNumAdresse;
            }
            public String extractNumber(final String str) {

                if(str == null || str.isEmpty()) return "";

                StringBuilder sb = new StringBuilder();
                boolean found = false;
                for(char c : str.toCharArray()){
                    if(Character.isDigit(c)){
                        sb.append(c);
                        found = true;
                    } else if(found){
                        // If we already found a digit before and this char is not a digit, stop looping
                        break;
                    }
                }

                return sb.toString();
            }
            public String checkUrl(){
             String sUrl =   url.getText().toString();
             if(sUrl.contains("https://")){
                 return sUrl;
             }
             else{
                 return "";
             }

            }
        });
    }



}