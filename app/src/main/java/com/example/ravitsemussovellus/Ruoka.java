package com.example.ravitsemussovellus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Ruoka extends AppCompatActivity {
    TextView tvCounter, tvTime;
    Button btnIncreament;
    Button btnDecreament;
    Button btnSave;
    FloatingActionButton infoButton;
    int counter = 0;
    TimePicker timepicker;
    private Calendar calendar;

    private ArrayList<String> Ruokatiedot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruoka);
        this.setFinishOnTouchOutside(false);

        this.Ruokatiedot = new ArrayList<String>();

        tvCounter = findViewById(R.id.tvCounter);
        btnIncreament = findViewById(R.id.btnIncreament);
        btnDecreament = findViewById(R.id.btnDecreament);
        timepicker = (TimePicker) findViewById(R.id.timePicker);
        btnSave = findViewById(R.id.btnSave);
        infoButton= findViewById(R.id.floatingActionButton);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hour = timepicker.getCurrentHour();
                int minute = timepicker.getCurrentMinute();
                Ruokatiedot.add(hour + ":" + minute);

                String count = tvCounter.getText().toString();
                Ruokatiedot.add(count);

                String list = "";
                for(String item : Ruokatiedot) {
                    list += item + "\n";
                }
             
                String text = "Tiedot Tallennettu";
                //kokeiltu tulostaa tiedot mitkä tallennettu arraylistiin
                Toast.makeText(Ruoka.this, text, Toast.LENGTH_SHORT).show();
                finish();

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

        this.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Ruoka.this);
                builder.setMessage("Suositeltu ateriarytmi päivässä on n. 3-4 tunnin välein. Päivän aikana olisi hyvä olla 4-6 ateriakertaa. " +
                        "Kasviksia, marjoja ja hedelmiä suositellaan päivässä vähintään 500 g tai kuusi kourallista/annosta.\n" +
                        "\n" +
                        "Kasviksilla tarkoitettaan esim. erilaisia salaattivihanneksia kuten kurkku, tomaatti, kaalit, sipulit ja juurekset kuten porkkana. Marjojen syöntisuositus on n. 2 dl/pv ja hedelmiä n.2 kpl/pv vaihdellen erilaisia ja eri värisiä vaihtoehtoja.\n" +
                        "\n" +
                        "Perunaa tai bataattia, eikä viljoja lasketa kasviksiin kuuluvaksi. ")
                        .setPositiveButton("Sulje", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });

    }


}
