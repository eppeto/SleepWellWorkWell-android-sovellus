package com.example.ravitsemussovellus;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class UniStressi extends AppCompatActivity {

    private Button btnUniStressi;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unistressi);

        this.btnUniStressi = findViewById(R.id.btnUniStressi);
        radioGroup = findViewById(R.id.radioGroupUni);
        radioGroup = findViewById(R.id.radioGroupStressi);

        Button buttonUniStressi = findViewById(R.id.btnUniStressi);
        buttonUniStressi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId=radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);


            }
        });

    }
    public void checkButton (View v){
        int radioId=radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);



    }
}