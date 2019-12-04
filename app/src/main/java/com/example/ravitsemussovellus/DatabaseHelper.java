package com.example.ravitsemussovellus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        db.execSQL("create table " + TABLE_LIIKUNTA_NAME +" (LIIKUNTA_ID INTEGER PRIMARY KEY AUTOINCREMENT,TYYPPI STRING,PVM DATETIME,KESTO DATETIME)");
        db.execSQL("create table " + TABLE_RUOKA_NAME +" (RUOKAILU_ID INTEGER PRIMARY KEY AUTOINCREMENT,PVM DATETIME,MAARA INTEGER,KELLO DATETIME)");
        db.execSQL("create table " + TABLE_UNISTRESSI_NAME +" (UNISTRESSI_ID INTEGER PRIMARY KEY AUTOINCREMENT,UNI_LAATU_ID INTEGER,STRESSI_MAARA_ID INTEGER,PVM DATETIME)");

       // db.execSQL("INSERT INTO " + TABLE_LIIKUNTA_NAME + "(TYYPPI,PVM,KESTO) VALUES (insertData_liikunta(tyyppi),insertData_liikunta(pvm),insertData_liikunta(kesto))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LIIKUNTA_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RUOKA_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_UNISTRESSI_NAME);
        onCreate(db);

    }
        // Liikuntatietojen lisäys tietokantaan
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
        // ravintotietojen lisäys tietokantaan
    public boolean insertData_ruoka(String pvm, int maara, String kello){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_RUOKA, pvm);
        contentValues.put(COL_3_RUOKA, maara);
        contentValues.put(COL_4_RUOKA, kello);
        long result = db.insert(TABLE_RUOKA_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
        // Uni ja stressi tietojen lisäys tietokantaan
    public boolean insertData_unistressi(int unilaatu, int stressi, String pvm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_UNISTRESSI, unilaatu);
        contentValues.put(COL_3_UNISTRESSI, stressi);
        contentValues.put(COL_4_UNISTRESSI, pvm);
        long result = db.insert(TABLE_UNISTRESSI_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getLiikuntaData(){
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor res_liikunta = db.rawQuery("SELECT * FROM " +TABLE_LIIKUNTA_NAME,null);

        return res_liikunta;
    }

    public Cursor getRuokaData(){
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor res_ruoka = db.rawQuery("SELECT * FROM " +TABLE_RUOKA_NAME,null);

        return res_ruoka;
    }

    public Cursor getUnistressiData(){
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor res_unistressi = db.rawQuery("SELECT * FROM " +TABLE_UNISTRESSI_NAME,null);

        return res_unistressi;
    }
    public Cursor getLiikuntaDataTanaan(){
        SQLiteDatabase db = this.getReadableDatabase ();
        String query = "SELECT * FROM " +TABLE_LIIKUNTA_NAME +  " WHERE date (datetime('now', 'localtime'))";
        Cursor cursor_liikunta = db.rawQuery (query, null);
        return  cursor_liikunta;
    }
}

