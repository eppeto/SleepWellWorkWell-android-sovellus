package com.example.ravitsemussovellus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // annetaan tietokannalle nimi
    public static final String DATABASE_NAME = "Tulokset.db";


    // annetaan liikuntatietojen taululle ja riveille nimet
    public static final String TABLE_LIIKUNTA_NAME = "Liikunta_table";
    public static final String COL_1_LIIKUNTA = "LIIKUNTA_ID";
    public static final String COL_2_LIIKUNTA = "TYYPPI";
    public static final String COL_3_LIIKUNTA = "PVM";
    public static final String COL_4_LIIKUNTA = "KESTO";


    // annetaan ruokailutietojen taululle ja riveille nimet
    public static final String TABLE_RUOKA_NAME = "Ruoka_table";
    public static final String COL_1_RUOKA = "RUOKAILU_ID";
    public static final String COL_2_RUOKA = "PVM";
    public static final String COL_3_RUOKA = "MAARA";
    public static final String COL_4_RUOKA = "KELLO";

    // annetaan uni- ja stressitietojen taululle ja riveille nimet
    public static final String TABLE_UNISTRESSI_NAME = "UniStressi_table";
    public static final String COL_1_UNISTRESSI = "UNISTRESSI_ID";
    public static final String COL_2_UNISTRESSI = "UNI_LAATU_ID";
    public static final String COL_3_UNISTRESSI = "STRESSI_MAARA_ID";
    public static final String COL_4_UNISTRESSI = "PVM";


    // alla oleva construktori luo tietokannan kutsuttaessa
    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    // alla oleva funktio luo tyhjät taulut tietokantaan soluineen
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_LIIKUNTA_NAME +" (LIIKUNTA_ID INTEGER PRIMARY KEY AUTOINCREMENT,TYYPPI STRING,PVM INTEGER,KESTO INTEGER)");
        db.execSQL("create table " + TABLE_RUOKA_NAME +" (RUOKAILU_ID INTEGER PRIMARY KEY AUTOINCREMENT,PVM INTEGER,MAARA INTEGER,KELLO INTEGER)");
        db.execSQL("create table " + TABLE_UNISTRESSI_NAME +" (UNISTRESSI_ID INTEGER PRIMARY KEY AUTOINCREMENT,UNI_LAATU_ID INTEGER,STRESSI_MAARA_ID INTEGER,PVM INTEGER)");

        db.execSQL("INSERT INTO " + TABLE_LIIKUNTA_NAME + "(TYYPPI,PVM,KESTO) VALUES (insertData_liikunta(tyyppi),insertData_liikunta(pvm),insertData_liikunta(kesto))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LIIKUNTA_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RUOKA_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_UNISTRESSI_NAME);
        onCreate(db);

    }

    public boolean insertData_liikunta(String tyyppi, String pvm, String kesto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_LIIKUNTA, tyyppi);
        contentValues.put(COL_3_LIIKUNTA, pvm);
        contentValues.put(COL_4_LIIKUNTA, kesto);
        long result = db.insert(TABLE_LIIKUNTA_NAME,null ,contentValues);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
