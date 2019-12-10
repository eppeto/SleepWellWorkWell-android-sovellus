package com.example.ravitsemussovellus;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Raportit extends AppCompatActivity{
    DatabaseHelper db;
    SimpleDateFormat formatter1 = new SimpleDateFormat ("dd-MM-yyyy");
    //    Kellonaikaparsija alla (ei välttämättä tarvita)
    //    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern ("HH:mm");


    public List<Integer> liikunta_id = new ArrayList<Integer> ();
    public List<String> tyyppi = new ArrayList<String> ();
    public List<String> pvm = new ArrayList<String> ();
    public List<String> kesto = new ArrayList<String> ();

    public int ruokailu_id;
    public int maara_ruoka;
    public Date pvm_ruoka;
    public List<String> kello_ruoka = new ArrayList<String>();

    public int unistressi_id;
    public int unilaatu;
    public int stressi;
    public Date pvm_unistressi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LiikuntaHakuTanaan ();
        RuokaHaku ();
        UniStressiHaku ();
        db = new DatabaseHelper (this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raportit);

        ViewPager viewPager = findViewById(R.id.viewpager);
        Adapter adapter = new Adapter(this, getSupportFragmentManager());
        adapter.liikunta_id = liikunta_id;
        adapter.tyyppi = tyyppi;
        adapter.pvm = pvm;
        adapter.kesto = kesto;
        adapter.ruokailu_id = ruokailu_id;
        adapter.maara_ruoka = maara_ruoka;
        adapter.pvm_ruoka = pvm_ruoka;
        adapter.kello_ruoka = kello_ruoka;
        adapter.unistressi_id = unistressi_id;
        adapter.unilaatu = unilaatu;
        adapter.stressi = stressi;
        adapter.pvm_unistressi = pvm_unistressi;
        viewPager.setAdapter(adapter);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Log.d ("testi","liikunta id =" + liikunta_id);
        Log.d("pvm = ",pvm.toString ());
        db.close ();
    }
    // public void LiikuntaHaku() {
    //    db = new DatabaseHelper (this);
    //     Cursor res = db.getLiikuntaData ();
    //     if(res.getCount () == 0) {
    //         // viesti jos tietokanta tyhjä
    //         showMessage ("error", "no data found");
    //         return;
    //     }
    //     else{
    //         while(res.moveToNext ()){
    //           liikunta_id = res.getInt (0);
    //           tyyppi = res.getString (1);
    //             try {
    //                  pvm = formatter1.parse (res.getString (2));
    //             } catch (ParseException e) {
    //                 e.printStackTrace ();
    //             }
    //             kesto = res.getString (3);
    //         }
    //    }
    //
    //
    // }
    public void LiikuntaHakuTanaan() {
        db = new DatabaseHelper (this);
        Cursor cursor_liikunta = db.getLiikuntaDataTanaan ();
        if(cursor_liikunta.getCount () == 0) {
            // viesti jos tietokanta tyhjä
            showMessage ("error", "no data found");
            return;
        }
        else{
            cursor_liikunta.moveToFirst ();
            while(!cursor_liikunta.isAfterLast ()){
                liikunta_id.add(cursor_liikunta.getInt (0));
                tyyppi.add(cursor_liikunta.getString (1));
                pvm.add(cursor_liikunta.getString (2));
                kesto.add(cursor_liikunta.getString (3));
                cursor_liikunta.moveToNext ();
            }
            cursor_liikunta.close ();
        }


    }

    public void RuokaHaku() {
        db = new DatabaseHelper (this);
        Cursor res = db.getRuokaData ();
        if(res.getCount () == 0) {
            // viesti jos tietokanta tyhjä
            showMessage ("error", "no data found");
            return;
        }
        else{
            res.moveToFirst ();
            while(!res.isAfterLast ()){
                ruokailu_id = res.getInt (0);
                try {
                    pvm_ruoka = formatter1.parse (res.getString (1));
                } catch (ParseException e) {
                    e.printStackTrace ();
                }
                maara_ruoka = res.getInt (2);
                kello_ruoka.add (res.getString (3));
                res.moveToNext ();
            }
            res.close ();

        }


    }

    public void UniStressiHaku() {
        db = new DatabaseHelper (this);
        Cursor res = db.getUnistressiData ();
        if(res.getCount () == 0) {
            // viesti jos tietokanta tyhjä
            showMessage ("error", "no data found");
            return;
        }
        else{
            while(res.moveToNext ()){
                unistressi_id = res.getInt (0);
                unilaatu = res.getInt (1);
                stressi = res.getInt (2);
                try {
                    pvm_unistressi = formatter1.parse (res.getString (3));
                } catch (ParseException e) {
                    e.printStackTrace ();
                }
            }
        }


    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder (this);
        builder.setCancelable (true);
        builder.setTitle (title);
        builder.setMessage (Message);
        builder.show();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}