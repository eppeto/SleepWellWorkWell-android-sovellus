package com.example.ravitsemussovellus;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class UniStressi extends AppCompatActivity {

    private Button btnUniStressi;
    private Spinner spinner1,spinner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unistressi);

        this.btnUniStressi = findViewById(R.id.btnUniStressi);
        this.spinner1 = findViewById(R.id.spinner1);

        this.spinner2 = findViewById(R.id.spinner2);


    }
}