package com.example.ravitsemussovellus;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Ruoka extends AppCompatActivity {
    TextView tvCounter, textDateRuoka;
    DatabaseHelper db;
    Button btnIncreament;
    Button btnDecreament;
    Button btnSave, btnBack;
    ImageButton btnVaihdaRuoka;
    FloatingActionButton infoButton;
    int counter = 0;
    TimePicker timepicker;
    int day, month, year;

    //private ArrayList<String> Ruokatiedot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruoka);
        this.setFinishOnTouchOutside(false);
        db = new DatabaseHelper(this);


        tvCounter = findViewById(R.id.tvCounter);
        btnIncreament = findViewById(R.id.btnIncreament);
        btnDecreament = findViewById(R.id.btnDecreament);
        textDateRuoka=findViewById(R.id.eTextDate);
        btnVaihdaRuoka=findViewById(R.id.btnVaihda);
        btnSave = findViewById(R.id.btnSave);
        btnBack=findViewById(R.id.btnback);
        infoButton= findViewById(R.id.floatingActionButton);
        timepicker=findViewById(R.id.timepicker);

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
        //datepicker
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        textDateRuoka.setText(thisDate);

        btnVaihdaRuoka.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        int s = monthOfYear + 1;
                        String a = dayOfMonth + "/"+ s +"/"+ year;
                        textDateRuoka.setText(a);
                    }
                };
                // Määritellään nykyhetki + min ja max päivät
                final Calendar c = Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(Ruoka.this, dpd, year, month, day);

                d.getDatePicker().setMaxDate((c.getTimeInMillis()));
                // asetetaan takarajaksi viikko
                c.add(Calendar.DATE, -6);
                // Set the Calendar new date as minimum date of date picker
                d.getDatePicker().setMinDate(c.getTimeInMillis());

                d.show();

            }
        });

        // Timepicker, jossa valitaan ruokailun klo aika

        // tuntien valinta


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


            // Tallenna napin onclick listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aika = (timepicker.getCurrentHour() + ":" + timepicker.getCurrentMinute());

                // Databaseen vienti. ---------------- HUOM!! KELLONAJASSA ON BUGI PITÄÄ KORJATA!!!! --------------------
                boolean isInserted = db.insertData_ruoka(textDateRuoka.getText().toString(),counter,aika);
                if (isInserted = true){
                    String text = "Tiedot Tallennettu";
                    Toast.makeText(Ruoka.this, text, Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    String text = "Tietoja ei ole tallennettu!!";
                    Toast.makeText(Ruoka.this, text, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
            // Takaisin napin onclick listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Tietoja ei ole tallennettu";
                Toast.makeText(Ruoka.this, text, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


}
