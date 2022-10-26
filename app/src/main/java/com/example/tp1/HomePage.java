package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
   DBHelper Tp1bd;
   EditText inputRecherche;
   TextView buttonRechercher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        inputRecherche = findViewById(R.id.inputRecherche);
       buttonRechercher = findViewById(R.id.researchButton);
       buttonRechercher.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomePage.this,resultatsRechercheOffre.class));
           }
       });

    }
}