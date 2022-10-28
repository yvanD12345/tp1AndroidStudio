package com.example.tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

     public static final String nom_bd = "Login.db";

    public DBHelper( Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase Tp1bd) {
        Tp1bd.execSQL("create Table users(username TEXT primary key, psw TEXT)");
        //Tp1bd.execSQL("CREATE TABLE IF NOT EXISTS offreEmploi(companyText TEXT primary key,Contact TEXT,Telephone NUMERIC,Courriel VARCHAR(255),ville TEXT,codePostal TEXT)");
        Tp1bd.execSQL("create Table offerTest(nomCompany Text primary key, email TEXT,contact TEXT,poste TEXT, ville TEXT, postalCode TEXT, adresse TEXT, telephone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Tp1bd, int oldVersion, int newVersion) {
        Tp1bd.execSQL("drop table if exists users");
        Tp1bd.execSQL("drop table if exists offerTest");
    }
    //permet d'inserer les donné que le user à entrer dans la bd et retourne un boolean si oui ou non l'insertion à pu se faire
    public Boolean insertionDansLaBd(String username, String psw){
        SQLiteDatabase Tp1bd = this.getWritableDatabase();
        //données qui seront insérer dans bd
        ContentValues dataInsert = new ContentValues();
        dataInsert.put("username",username);
        dataInsert.put("psw",psw);
        long result = Tp1bd.insert("users",null,dataInsert);

        if(result ==-1){
            return false;
        }
        else return true;

    }
    public boolean insertoffer(String nomCompany , String email, String contact,String poste,String ville,String postalCode,String adresse, String telephone){
        SQLiteDatabase Tp1bd = this.getWritableDatabase();
        ContentValues offer = new ContentValues();
        offer.put("nomCompany", nomCompany);
        offer.put("email",email);
        offer.put("contact",contact);
        offer.put("poste",poste);
        offer.put("adresse",adresse);
        offer.put("postalCode",postalCode);
        offer.put("ville",ville);
        offer.put("telephone",telephone);

        long resultat = Tp1bd.insert("offerTest",null,offer);
        if(resultat == -1){
            return false;
        }
        else return true;

    }
    public Cursor getRecherche(String recherche){
        SQLiteDatabase Tp1bd = this.getWritableDatabase();
        Cursor resultatRecherche;
        if(recherche.equals("all")) {
             resultatRecherche = Tp1bd.rawQuery("Select * from offerTest", null);
        }
        else {
             resultatRecherche = Tp1bd.rawQuery("Select * from offerTest where nomCompany = ?", new String[]{recherche});

        }
        return resultatRecherche;
    }
    //fait une recherche dans la bd pour voir s'il y a au moin une occurence avec le userame entré retourne true si au moin une occurence est trouvé
    public Boolean validationUsername(String username){
        SQLiteDatabase Tp1bd = this.getWritableDatabase();
        Cursor resultatQuery = Tp1bd.rawQuery("Select * from users where username = ?", new String[] {username});
        if(resultatQuery.getCount() > 0){
            return true;
        }
        else return false;
    }
    //fait une recherche dans la bd pour voir s'il y a au moin une occurence du psw du userame entré retourne true si au moin une occurence est trouvé
    public Boolean validationUserPsw(String username, String psw){
        SQLiteDatabase Tp1bd = this.getWritableDatabase();
        Cursor resulatQuery = Tp1bd.rawQuery("select * from users where username = ? and psw = ?",new String[] {username,psw});
        if(resulatQuery.getCount() > 0){
            return true;
        }
        else return false;
    }
}
