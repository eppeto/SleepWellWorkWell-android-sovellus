package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ruoka extends AppCompatActivity {
    TextView tvCounter;
    Button btnIncreament;
    Button btnDecreament;
    int counter = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.ruoka);

            tvCounter = findViewById(R.id.tvCounter);
            btnIncreament = findViewById(R.id.btnIncreament);
            btnDecreament = findViewById(R.id.btnDecreament);

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
                if(counter>0){
                    counter = counter - 1;
                    tvCounter.setText(String.valueOf(counter));
                }
            }
            });

        }
    }
