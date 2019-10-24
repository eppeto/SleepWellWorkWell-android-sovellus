package com.example.ravitsemussovellus;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KyselyActivity extends AppCompatActivity {
    private Button btnuni, btnruoka, btnliikunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kysely);

        this.btnuni = findViewById(R.id.btnuni);
        this.btnruoka = findViewById(R.id.btnruoka);
        this.btnliikunta = findViewById(R.id.btnliikunta);

        // Buttoneiden OnClickListenerit

        btnuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),
                        UniStressi.class);
                startActivity(myIntent);
            }
        });

        btnruoka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ruoka activityn avaus dialogimuodossa
                Intent myIntent = new Intent(getApplicationContext(),
                        Ruoka.class);
                startActivity(myIntent);
            }

        });

        btnliikunta.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            /*Intent myIntent = new Intent(getApplicationContext(),
                    Liikunta.class);
            startActivity(myIntent);*/
                    final Dialog builder = new Dialog(KyselyActivity.this);
                    builder.setContentView(R.layout.liikunta);
                /*builder.setMessage("Palaa alkuun")
                        .setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Ei", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();*/
                    builder.show();
                }
        });

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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
