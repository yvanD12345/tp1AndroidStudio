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
    ArrayList<OffreStageListModel> listOffre;

    adapter adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        inputRecherche = findViewById(R.id.inputRecherche);
       buttonRechercher = findViewById(R.id.researchButton);
        Tp1bd = new DBHelper(this);
       /* companyName = new ArrayList<>();
        poste = new ArrayList<>();*/
         listOffre  = new ArrayList<OffreStageListModel>();
        recyclerView = findViewById(R.id.recyclerview);
        adapt = new adapter(this,/*companyName,poste*/listOffre);
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        afficherTouteLesOffre();
       buttonRechercher.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               inputRecherche = findViewById(R.id.inputRecherche);
               String sRecherche = inputRecherche.getText().toString();
               Intent launchResult = new Intent( HomePage.this,resultatsRechercheOffre.class);
               launchResult.putExtra("key", sRecherche);
               startActivity(launchResult);
           }
       });

    }

    private void afficherTouteLesOffre() {
        Cursor resultatRecherche = Tp1bd.getRecherche("all");
        if(resultatRecherche.getCount()== 0){
            Toast.makeText(HomePage.this,"aucune offre trouvé avec l'element recherchée",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(resultatRecherche.moveToNext()){
                listOffre.add(new OffreStageListModel(resultatRecherche.getString(0),resultatRecherche.getString(3)));
            }
        }
    }
}