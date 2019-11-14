package com.example.ravitsemussovellus;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Liikunta extends AppCompatActivity {
    DatabaseHelper db;
    Button btnTallenna, btnback;
    ImageButton btnVaihdaSport;
    TextView textDateSport;
    ToggleButton tbtnkestavyys, tbtnlihasvoima, tbtnliikkuvuus;
    FloatingActionButton infoButton;
    int day, month, year;
    String tyyppi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liikunta);
        db = new DatabaseHelper(this);
        textDateSport = findViewById(R.id.textDateSport);
        btnVaihdaSport = findViewById(R.id.btnVaihdaSport);
        tbtnkestavyys = findViewById(R.id.tbtnkestavyys);
        tbtnlihasvoima = findViewById(R.id.tbtnlihasvoima);
        tbtnliikkuvuus = findViewById(R.id.tbtnliikkuvuus);
        btnTallenna = findViewById(R.id.btntallenna);
        btnback=findViewById(R.id.btnback);
        infoButton= findViewById(R.id.floatingActionButton);

        //datepicker
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        textDateSport.setText(thisDate);

        btnVaihdaSport.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        int s = monthOfYear + 1;
                        String a = dayOfMonth + "."+ s +"."+ year;
                        textDateSport.setText(a);
                    }
                };
                // Määritellään nykyhetki + min ja max päivät
                final Calendar c = Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(Liikunta.this, dpd, year, month, day);
                d.getDatePicker().setMaxDate((c.getTimeInMillis()));
                // asetetaan takarajaksi viikko
                c.add(Calendar.DATE, -6);
                // Set the Calendar new date as minimum date of date picker
                d.getDatePicker().setMinDate(c.getTimeInMillis());

                d.show();

            }
        });

        // Harjoituksen tyypin valinnan listenerit
        // kestävyys
        tbtnkestavyys.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnlihasvoima.setChecked(false);
                    tbtnliikkuvuus.setChecked(false);
                    tyyppi = "kestävyys";
                    // tausta vaihdetaan
                    tbtnkestavyys.setPadding(5,5,5,5);
                    tbtnkestavyys.setBackground(getResources().getDrawable(R.drawable.round_buttons_green));
                } else {
                    // The toggle is disabled
                    // tausta vaihdetaan takaisin
                    tbtnkestavyys.setPadding(0,0,0,0);
                    tbtnkestavyys.setBackground(getResources().getDrawable(R.drawable.round_buttons_blue));
                }
            }
        });
        // Lihasvoima
        tbtnlihasvoima.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnkestavyys.setChecked(false);
                    tbtnliikkuvuus.setChecked(false);
                    tyyppi = "lihasvoima";
                    // tausta vaihdetaan
                    tbtnlihasvoima.setPadding(5,5,5,5);
                    tbtnlihasvoima.setBackground(getResources().getDrawable(R.drawable.round_buttons_green));
                } else {
                    // The toggle is disabled
                    // tausta vaihdetaan takaisin
                    tbtnlihasvoima.setPadding(0,0,0,0);
                    tbtnlihasvoima.setBackground(getResources().getDrawable(R.drawable.round_buttons_blue));
                }
            }
        });

        // Liikkuvuus
        tbtnliikkuvuus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnlihasvoima.setChecked(false);
                    tbtnkestavyys.setChecked(false);
                    tyyppi = "liikkuvuus";
                    // tausta vaihdetaan
                    tbtnliikkuvuus.setPadding(5,5,5,5);
                    tbtnliikkuvuus.setBackground(getResources().getDrawable(R.drawable.round_buttons_green));
                } else {
                    // The toggle is disabled
                    // tausta vaihdetaan takaisin
                    tbtnliikkuvuus.setPadding(0,0,0,0);
                    tbtnliikkuvuus.setBackground(getResources().getDrawable(R.drawable.round_buttons_blue));
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

        this.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Liikunta.this);
                builder.setMessage("Kestävyysliikunta eli aerobinen liikunta on yhtäjaksoista, isoja lihasryhmiä kuormittavaa. Esim. kävely-, juoksu-, pyöräilylenkki, uinti jne.\n" +
                        "\n" +
                        "Lihasvoimaharjoittelu on lihaksia vähintään kohtalaisesti kuormittavaa toimintaa niiden voimantuoton ja yleensä myös niiden massan ylläpitämiseksi tai lisäämiseksi. Esim. kuntosalityöskentely, kuntopiiri, kahvakuulatreeni jne.\n" +
                        "\n" +
                        "Liikkuvuus eli notkeus tarkoittaa kehon nivelten liikelaajuutta. Liikkuvuus on yksilöllinen ominaisuus mikä koostuu nivelten liikkuvuudesta, lihasten ja niveltä ympäröivien kudosten venyvyydestä. (Liikkuvuuteen vaikuttavia tekijöitä ovat perimä, ulkoiset olosuhteet, ikä, hormonaaliset ja hermostolliset tekijät). Suluissa olevan voi ottaa pois, jos tuo selitysosio on jo liian pitkä. Esim. jooga, venyttelyt, pilates jne. ")
                        .setPositiveButton("Sulje", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
        // Tallenna napin onclick listener
        btnTallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kesto = (String.valueOf(hp.getValue())+String.valueOf(mp.getValue()));

               boolean isInserted = db.insertData_liikunta(tyyppi,textDateSport.getText().toString(),kesto);
                if (isInserted = true){
                    String text = "Tiedot Tallennettu";
                    Toast.makeText(Liikunta.this, text, Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    String text = "Tietoja ei ole tallennettu!!";
                    Toast.makeText(Liikunta.this, text, Toast.LENGTH_SHORT).show();
                    finish();
                }


            }

        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Tietoja ei ole tallennettu";
                Toast.makeText(Liikunta.this, text, Toast.LENGTH_SHORT).show();
                finish();

            }

        });

    }
}
