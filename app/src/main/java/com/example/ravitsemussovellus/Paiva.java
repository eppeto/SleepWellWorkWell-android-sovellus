package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Paiva extends Fragment {
    public Paiva() {
        // Required empty public constructor
    }
    public int liikunta_id;
    public String tyyppi;
    public Date pvm;
    public String kesto;

    public int ruokailu_id;
    public int maara_ruoka;
    public Date pvm_ruoka;
    public String kello_ruoka;

    public int unistressi_id;
    public int unilaatu;
    public int stressi;
    public Date pvm_unistressi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paiva, container, false);
        // Päivämääräotsikko
        TextView paivamaaraotsikko = (TextView) view.findViewById(R.id.PaivamaaraOtsikko);
        // Unen ja stressinmäärä kuvat
        ImageView unenlaatu = (ImageView) view.findViewById(R.id.unikuva);
        ImageView stressimaara = (ImageView) view.findViewById(R.id.stressikuva);

        // Ruokailumäärä, marjakouralliset ja ruokailuväli kuvat ja lukumäärät
        TextView ruokamaara = (TextView) view.findViewById(R.id.ruokamaaraLuku);
        ImageView ruokamaarakuva = (ImageView) view.findViewById(R.id.ruokamaarakuva);
        TextView marjamaara = (TextView) view.findViewById(R.id.marjamaaraLuku);
        ImageView marjamaarakuva = (ImageView) view.findViewById(R.id.marjakuva);
        TextView ruokavaliluku = (TextView) view.findViewById(R.id.ruokailuvaliLuku);
        ImageView ruokavalikuva = (ImageView) view.findViewById(R.id.ruokailuvaliKuva);

        // Liikunnan kuvat ja tekstit
        TextView liikunnanyhteiskestoluku = (TextView) view.findViewById(R.id.liikuntamaaraLuku);
        ImageView liikunnanyhteiskestokuva = (ImageView) view.findViewById(R.id.liikuntamaaraKuva);
        TextView kestavyysluku = (TextView) view.findViewById(R.id.kestavyysLuku);
        TextView liikkuvuusluku = (TextView) view.findViewById(R.id.liikkuvuusLuku);
        TextView lihasvoimaluku = (TextView) view.findViewById(R.id.lihasvoimaLuku);



        // Unen ja stressinmäärän kuvien muuttaminen
        // unenlaatu erinomainen = 2131296262
        // unenlaatu hyvä = 2131296266
        // unenlaatu huono = 2131296264

        // stressinmäärä ei ollenkaan = 2131296261
        // stressinmäärä sopiva = 2131296265
        // stressinmäärä liikaa = 2131296263

            // PÄIVÄMÄÄRÄ OTSIKON MUUTTAMINEN KULUVALLE PÄIVÄMÄÄRÄLLE
        DateFormat df = new SimpleDateFormat("dd.MM.yy");
        String tanaan = df.format(Calendar.getInstance().getTime());
        paivamaaraotsikko.setText(tanaan);

            // Unen laadun kuvan muuttaminen
        if (unilaatu == 2131296262){
            unenlaatu.setImageResource(R.drawable.good);
        }
        if (unilaatu == 2131296266 ){
            unenlaatu.setImageResource(R.drawable.neutral);
        }
        if (unilaatu == 2131296264 ){
            unenlaatu.setImageResource(R.drawable.bad);
        }

            // Stressinmäärän kuvan muuttaminen
        if (stressi == 2131296261 ){
            stressimaara.setImageResource(R.drawable.good);
        }
        if (stressi == 2131296265 ){
            stressimaara.setImageResource(R.drawable.neutral);
        }
        if (stressi == 2131296263 ){
            stressimaara.setImageResource(R.drawable.bad);
        }

        // Ruokalun lukujen ja kuvan muuttaminen

        //marjojen määrä
        marjamaara.setText(String.valueOf(maara_ruoka));
        if (maara_ruoka > 4){
            marjamaarakuva.setImageResource(R.drawable.good);
        }
        if (maara_ruoka < 5 && maara_ruoka > 1 ){
            marjamaarakuva.setImageResource(R.drawable.neutral);
        }
        if (maara_ruoka < 2){
            marjamaarakuva.setImageResource(R.drawable.bad);
        }
        // TÄHÄN MARJOJEN YHTEISMÄÄRÄN LASKEMINEN JA SIJOITUS


        // Liikunta

        if (tyyppi.equals("kestävyys")){
            String[] parts = kesto.split(":");
            kestavyysluku.setText(parts[0]+"h "+parts[1]+"min");
        }
        if (tyyppi.equals("liikkuvuus")){
            String[] parts = kesto.split(":");
            liikkuvuusluku.setText(parts[0]+"h "+parts[1]+"min");
        }
        if (tyyppi.equals("lihasvoima")){
            String[] parts = kesto.split(":");
            lihasvoimaluku.setText(parts[0]+"h "+parts[1]+"min");
        }

        Log.d("TESTI",tyyppi);
        Log.d("KESTO",kesto);
        return view;
    }

}