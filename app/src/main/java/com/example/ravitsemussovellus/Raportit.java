package com.example.ravitsemussovellus;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Raportit extends AppCompatActivity {
    DatabaseHelper db;
    public int liikunta_id;
    public String tyyppi;
    public LocalDateTime pvm;
    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern ("dd-MM-yyyy");
    public LocalDateTime kesto;
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern ("HH:mm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper (this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raportit);

        ViewPager viewPager = findViewById(R.id.viewpager);
        Adapter adapter = new Adapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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
              pvm = LocalDateTime.parse (res.getString (2),formatter1);
              kesto = LocalDateTime.parse (res.getString (3),formatter2);
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