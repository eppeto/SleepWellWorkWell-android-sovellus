package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Liikunta extends AppCompatActivity {
    Button btnTallenna;
    ToggleButton tbtnkestavyys, tbtnlihasvoima, tbtnliikkuvuus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liikunta);

        tbtnkestavyys = findViewById(R.id.tbtnkestavyys);
        tbtnlihasvoima = findViewById(R.id.tbtnlihasvoima);
        tbtnliikkuvuus = findViewById(R.id.tbtnliikkuvuus);
        btnTallenna = findViewById(R.id.btntallenna);

        // Harjoituksen tyypin valinnan listenerit
        // kestävyys
        tbtnkestavyys.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnlihasvoima.setChecked(false);
                    tbtnliikkuvuus.setChecked(false);
                } else {
                    // The toggle is disabled
                }
            }
        });
        // Lihasvoima
        tbtnlihasvoima.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnkestavyys.setChecked(false);
                    tbtnliikkuvuus.setChecked(false);
                } else {
                    // The toggle is disabled
                }
            }
        });

        // Liikkuvuus
        tbtnliikkuvuus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnlihasvoima.setChecked(false);
                    tbtnkestavyys.setChecked(false);
                } else {
                    // The toggle is disabled
                }
            }
        });



        // Numberpicker, jossa valitaan liikunnan kesto

        // tuntien valinta
        final NumberPicker hp = findViewById(R.id.hourpicker);
        hp.setMaxValue(10);
        hp.setMinValue(0);
        hp.setValue(1);
        hp.setWrapSelectorWheel(true);


        // Esimerkki OnValueChangeListeneristä jos tarvitaan tallennukseen

        /*hp.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String text = "Changed from " + oldVal + " to " + newVal;
                Toast.makeText(Liikunta.this, text, Toast.LENGTH_SHORT).show();
            }
            });*/


        // minuuttien valinta
        final NumberPicker mp = findViewById(R.id.minutepicker);
        mp.setMaxValue(59);
        mp.setMinValue(0);
        mp.setWrapSelectorWheel(true);


        // Tallenna napin onclick listener
        btnTallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Tiedot Tallennettu";
                Toast.makeText(Liikunta.this, text, Toast.LENGTH_SHORT).show();

            }

        });

    }
}
