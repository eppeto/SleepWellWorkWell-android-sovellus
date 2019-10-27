package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class Liikunta extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liikunta);


        // Numberpicker kahdella tavalla tehty ja kumpikaan ei VIELÄ toimi.

        // tuntien valinta
        final NumberPicker hp = findViewById(R.id.hourpicker);
        String[] hours = new String[10];
        for(int i=0; i<hours.length; i++)
            hours[i] = Integer.toString(i);
        hp.setMaxValue(10);
        hp.setMinValue(0);
        hp.setDisplayedValues(hours);
        hp.setValue(1);
        hp.setWrapSelectorWheel(true);

        // minuuttien valinta
        NumberPicker mp = findViewById(R.id.minutepicker);
        mp.setMaxValue(59);
        mp.setMinValue(0);
        mp.setWrapSelectorWheel(true);

    }
}
