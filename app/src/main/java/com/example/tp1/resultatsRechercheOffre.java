package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class resultatsRechercheOffre extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> companyName, email,contact;
    DBHelper Tp1bd;
    adapter adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats_recherche_offre);
        Tp1bd = new DBHelper(this);
        companyName = new ArrayList<>();
        email = new ArrayList<>();
        contact = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapt = new adapter(this,companyName,email,contact);
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        afficherResultatRecherche();
    }

    private void afficherResultatRecherche() {
        Cursor resultatRecherche = Tp1bd.getRecherche();
        if(resultatRecherche.getCount()== 0){
            Toast.makeText(resultatsRechercheOffre.this,"aucune offre trouvé avec l'element recherchée",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(resultatRecherche.moveToNext()){
                companyName.add(resultatRecherche.getString(0));
                email.add(resultatRecherche.getString(1));
                contact.add(resultatRecherche.getString(2));
            }
        }
    }
}