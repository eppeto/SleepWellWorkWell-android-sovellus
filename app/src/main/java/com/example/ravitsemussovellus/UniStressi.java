package com.example.ravitsemussovellus;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.widget.TextView;
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

        btnUniStressi = findViewById(R.id.btnUniStressi);
        radioGroup = findViewById(R.id.radioGroupUni);
        radioGroup = findViewById(R.id.radioGroupStressi);

        Button buttonUniStressi = findViewById(R.id.btnUniStressi);
        buttonUniStressi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId=radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
                String text = "Tiedot Tallennettu";
                Toast.makeText(UniStressi.this, text, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyy");
    String dateTime = simpleDateFormat.format(calendar.getTime());

    }
    public void checkButton (View v){
        int radioId=radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

    }

}