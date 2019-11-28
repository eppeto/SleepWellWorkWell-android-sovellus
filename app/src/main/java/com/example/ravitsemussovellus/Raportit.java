package com.example.ravitsemussovellus;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Raportit extends AppCompatActivity{
    DatabaseHelper db;
    public int liikunta_id;
    public String tyyppi;
    SimpleDateFormat formatter1 = new SimpleDateFormat ("dd/MM/yyyy");
    public Date pvm;
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern ("HH:mm");
    public String kesto;
    private static TextView litxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LiikuntaHaku ();
        db = new DatabaseHelper (this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raportit);

        ViewPager viewPager = findViewById(R.id.viewpager);
        Adapter adapter = new Adapter(this, getSupportFragmentManager());
        adapter.liikunta_id = liikunta_id;
        adapter.tyyppi = tyyppi;
        adapter.pvm = pvm;
        adapter.kesto = kesto;
        viewPager.setAdapter(adapter);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Log.d ("testi","liikunta id =" + liikunta_id);
    }
    public void LiikuntaHaku() {
        db = new DatabaseHelper (this);
        Cursor res = db.getLiikuntaData ();
        if(res.getCount () == 0) {
            // viesti jos tietokanta tyhjä
            showMessage ("error", "no data found");
            return;
        }
        else{
            while(res.moveToNext ()){
              liikunta_id = res.getInt (0);
              tyyppi = res.getString (1);
                try {
                    pvm = formatter1.parse (res.getString (2));
                } catch (ParseException e) {
                    e.printStackTrace ();
                }
                kesto = res.getString (3);
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