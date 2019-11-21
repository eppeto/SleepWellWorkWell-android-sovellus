package com.example.ravitsemussovellus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    private Button btnKysely, btnRaportit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // kutsutaan databasehelperin konstruktioria, joka luo tietokannan
        myDb = new DatabaseHelper(this);

        this.btnKysely =  findViewById(R.id.btnKysely);
        this.btnRaportit = findViewById(R.id.btnRaportit);


        btnKysely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kysely-activityn (näkymän) avaus
                Intent myIntent = new Intent(getApplicationContext(),
                        KyselyActivity.class);
                startActivity(myIntent);
            }
            });


        btnRaportit.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick (View v) {
                    // Raportit-activityn (näkymän) avaus
                    Intent myIntent = new Intent(MainActivity.this,
                            Raportit.class);
                    startActivity(myIntent);
                }
        });




    }
}


