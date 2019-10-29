package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Ruoka extends AppCompatActivity {
    TextView tvCounter, tvTime;
    Button btnIncreament;
    Button btnDecreament;
    Button btnSave;
    int counter = 0;
    TimePicker timepicker;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruoka);
        this.setFinishOnTouchOutside(false);

        tvCounter = findViewById(R.id.tvCounter);
        btnIncreament = findViewById(R.id.btnIncreament);
        btnDecreament = findViewById(R.id.btnDecreament);
        timepicker = (TimePicker) findViewById(R.id.timePicker);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "Tiedot Tallennettu";
                Toast.makeText(Ruoka.this, text, Toast.LENGTH_SHORT).show();

            }
        });

        //Kasvikset/marjat/hedelmät counter
        tvCounter.setText("0");

        btnIncreament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter = counter + 1;
                tvCounter.setText(String.valueOf(counter));
            }

        });

        btnDecreament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter = counter - 1;
                    tvCounter.setText(String.valueOf(counter));
                }
            }
        });


        //timepicker
        timepicker.setIs24HourView(true);

    }


}
