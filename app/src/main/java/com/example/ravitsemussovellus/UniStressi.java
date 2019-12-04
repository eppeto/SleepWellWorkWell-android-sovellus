package com.example.ravitsemussovellus;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class UniStressi extends AppCompatActivity {

    private Button btnUniTallenna, btnUniBack;
    DatabaseHelper db;
    RadioGroup radioGroup, radioGroup2;
    RadioButton radioButton;
    ImageButton btnVaihdaUni;
    TextView textDateUni;
    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unistressi);
        db = new DatabaseHelper(this);

        btnVaihdaUni=findViewById(R.id.btnVaihdaUni);
        textDateUni=findViewById(R.id.textDateUni);
        btnUniTallenna = findViewById(R.id.btnUniTallenna);
        radioGroup = findViewById(R.id.radioGroupUni);
        radioGroup2 = findViewById(R.id.radioGroupStressi);
        btnUniBack=findViewById(R.id.btnUniBack);


        //datepicker
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM-yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        textDateUni.setText(thisDate);

        btnVaihdaUni.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        int s = monthOfYear + 1;
                        String a = dayOfMonth + "-"+ s +"-"+ year;
                        textDateUni.setText(a);
                    }
                };
                // Määritellään nykyhetki + min ja max päivät
                final Calendar c = Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(UniStressi.this, dpd, year,  month, day);
                d.getDatePicker().setMaxDate((c.getTimeInMillis()));
                // asetetaan takarajaksi viikko
                c.add(Calendar.DATE, -6);
                // Set the Calendar new date as minimum date of date picker
                d.getDatePicker().setMinDate(c.getTimeInMillis());

                d.show();

            }
        });
        btnUniTallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int radioId=radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);*/
                if (radioGroup.getCheckedRadioButtonId() == -1 || radioGroup2.getCheckedRadioButtonId() == -1) {
                    String text = "Valitse uni- ja stressitiedot!";
                    Toast.makeText(UniStressi.this, text, Toast.LENGTH_SHORT).show();
                } else{
                    // Databaseen vienti
                    boolean isInserted = db.insertData_unistressi(radioGroup.getCheckedRadioButtonId(), radioGroup2.getCheckedRadioButtonId(), textDateUni.getText().toString());
                    if (isInserted = true) {
                        String text = "Tiedot Tallennettu";
                        Toast.makeText(UniStressi.this, text, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        String text = "Tietoja ei ole tallennettu!!";
                        Toast.makeText(UniStressi.this, text, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        btnUniBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Tietoja ei ole tallennettu";
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