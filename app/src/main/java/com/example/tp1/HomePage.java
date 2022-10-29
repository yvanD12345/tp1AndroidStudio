package com.example.tp1;

import static com.example.tp1.Constants.ERROR_DIALOG_REQUEST;
import static com.example.tp1.Constants.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION;
import static com.example.tp1.Constants.PERMISSIONS_REQUEST_ENABLE_GPS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
   DBHelper Tp1bd;
   EditText inputRecherche;
   TextView buttonRechercher;
   ImageView mapButton;
    RecyclerView recyclerView;
    ArrayList<String> companyName,poste;
    ArrayList<OffreStageListModel> listOffre;
    private  boolean mLocationPermissionGranted= false;
    public static final String TAG = "homeerror";
    adapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        inputRecherche = findViewById(R.id.inputRecherche);
       buttonRechercher = findViewById(R.id.researchButton);
       mapButton = findViewById(R.id.buttonMap);
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
       mapButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent showmap = new Intent(HomePage.this,MapsActivity.class);
               startActivity(showmap);
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