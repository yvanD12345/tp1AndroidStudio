package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
   DBHelper Tp1bd;
   EditText inputRecherche;
   TextView buttonRechercher;
    RecyclerView recyclerView;
    ArrayList<String> companyName,poste;

    adapter adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        inputRecherche = findViewById(R.id.inputRecherche);
       buttonRechercher = findViewById(R.id.researchButton);
        Tp1bd = new DBHelper(this);
        companyName = new ArrayList<>();
        poste = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapt = new adapter(this,companyName,poste);
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        afficherTouteLesOffre();
       buttonRechercher.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomePage.this,resultatsRechercheOffre.class));
           }
       });

    }

    private void afficherTouteLesOffre() {
        Cursor resultatRecherche = Tp1bd.getRecherche();
        if(resultatRecherche.getCount()== 0){
            Toast.makeText(HomePage.this,"aucune offre trouvé avec l'element recherchée",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(resultatRecherche.moveToNext()){
                companyName.add(resultatRecherche.getString(0));
                poste.add(resultatRecherche.getString(3));
            }
        }
    }
}