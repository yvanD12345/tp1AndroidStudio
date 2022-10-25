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
    }

    @Override
    public void onUpgrade(SQLiteDatabase Tp1bd, int oldVersion, int newVersion) {
        Tp1bd.execSQL("drop table if exists users");
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
