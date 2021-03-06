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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Paiva extends Fragment {
    public Paiva() {
        // Required empty public constructor
    }
    public List<Integer> liikunta_id = new ArrayList<Integer> ();
    public List<String> tyyppi = new ArrayList<String> ();
    public List<String> pvm = new ArrayList<String> ();
    public List<String> kesto = new ArrayList<String> ();

    public int ruokailu_id;
    public List<Integer> maara_ruoka = new ArrayList<Integer>();
    public List<String> pvm_ruoka = new ArrayList<String>();
    public List<String> kello_ruoka = new ArrayList<String>();

    public int unistressi_id;
    public String unilaatu;
    public String stressi;
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
        //TextView ruokavaliluku = (TextView) view.findViewById(R.id.ruokailuvaliLuku);
        //ImageView ruokavalikuva = (ImageView) view.findViewById(R.id.ruokailuvaliKuva);

        // Liikunnan kuvat ja tekstit
        TextView kestavyysluku = (TextView) view.findViewById(R.id.kestavyysLuku);
        TextView liikkuvuusluku = (TextView) view.findViewById(R.id.liikkuvuusLuku);
        TextView lihasvoimaluku = (TextView) view.findViewById(R.id.lihasvoimaLuku);



        // Unen ja stressinmäärän kuvien muuttaminen
        // unenlaatu erinomainen = 2131296262 1
        // unenlaatu hyvä = 2131296266 2
        // unenlaatu huono = 2131296264 3

        // stressinmäärä ei ollenkaan = 2131296261 1
        // stressinmäärä sopiva = 2131296265 2
        // stressinmäärä liikaa = 2131296263 3

            // PÄIVÄMÄÄRÄ OTSIKON MUUTTAMINEN KULUVALLE PÄIVÄMÄÄRÄLLE
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String tanaan = df.format(Calendar.getInstance().getTime());
        String pvm_tanaan = null;
        if(pvm.size()> 0) {
            pvm_tanaan = pvm.get(pvm.size() - 1);
        }
        paivamaaraotsikko.setText(tanaan);

            // Unen laadun kuvan muuttaminen
        if (unilaatu.matches ( "RbtnErinUni")){
            unenlaatu.setImageResource(R.drawable.good);
        }
        if (unilaatu.matches ( "RbtnHyvaUni")){
            unenlaatu.setImageResource(R.drawable.neutral);
        }
        if (unilaatu.matches ("RbtnHuonoUni")){
            unenlaatu.setImageResource(R.drawable.bad);
        }

            // Stressinmäärän kuvan muuttaminen
        if (stressi.matches ("RbtnErinStressi")){
            stressimaara.setImageResource(R.drawable.good);
        }
        if (stressi.matches ("RbtnHyvaStressi")){
            stressimaara.setImageResource(R.drawable.neutral);
        }
        if (stressi.matches ("RbtnHuonoStressi")){
            stressimaara.setImageResource(R.drawable.bad);
        }

        // Ruokalun lukujen ja kuvan muuttaminen

        //marjojen määrä
        int marjakoko = maara_ruoka.size();
        int laskuri = 0;
        for (int k = 0; k < maara_ruoka.size(); k++){
            marjakoko--;
            if (pvm_ruoka.get(marjakoko).matches(pvm_tanaan)){
                Log.d("marjojen määrä ennen lisäystä:",String.valueOf(laskuri));
                laskuri = laskuri + maara_ruoka.get(marjakoko);
                Log.d("marjojen määrä lisäyksen jälkeen:",String.valueOf(laskuri));
            }
        }
        marjamaara.setText(String.valueOf(laskuri));
        if (laskuri > 4){
            marjamaarakuva.setImageResource(R.drawable.good);
            Log.d("meneekö tähän","unikuva hyvä!");
        }
        if (laskuri < 5 && laskuri > 1 ){
            marjamaarakuva.setImageResource(R.drawable.neutral);
            Log.d("meneekö tähän","unikuva neutraali!");
        }
        if (laskuri < 2){
            marjamaarakuva.setImageResource(R.drawable.bad);
            Log.d("meneekö tähän","unikuva paska!");
        }
        // TÄHÄN MARJOJEN YHTEISMÄÄRÄN LASKEMINEN JA SIJOITUS
        int ruokakoko = (pvm_ruoka.size());
        int ruokailujenmaara = 0;
            ruokamaara.setText("Et ole kirjannut ruokailua tänään");
        for (int j = 0; j < pvm_ruoka.size (); j++){
            ruokakoko--;
            if (pvm_ruoka.get(ruokakoko).matches(pvm_tanaan)){
                ruokailujenmaara++;
                Log.d("ruokailujen lukumäärä:",String.valueOf(ruokailujenmaara));
                ruokamaara.setText(String.valueOf(ruokailujenmaara));
            }

        }
        //ruokamaara.setText(String.valueOf(ruokailujenmaara));

        // Liikunta
        int koko = (tyyppi.size());
        int koko3 = (tyyppi.size());
        int koko2 = (kesto.size());
        for(int i = 0; i<koko3;i++) {
            koko--;
            koko2--;
            Log.d("pvm tanaan", pvm_tanaan);
            if (tyyppi.get(koko) != null && pvm.get(koko) != null) {
                if (tyyppi.get(koko).matches("kestävyys") && pvm.get(koko).matches(pvm_tanaan)) {
                    String[] parts = kesto.get(koko2).split(":");
                    kestavyysluku.setText(parts[0] + "h " + parts[1] + "min");
                }


                if (tyyppi.get(koko).matches("liikkuvuus") && pvm.get(koko).matches(pvm_tanaan)) {
                    String[] parts2 = kesto.get(koko2).split(":");
                    liikkuvuusluku.setText(parts2[0] + "h " + parts2[1] + "min");
                }


                if (tyyppi.get(koko).matches("lihasvoima") && pvm.get(koko).matches(pvm_tanaan)) {
                    String[] parts3 = kesto.get(koko2).split(":");
                    lihasvoimaluku.setText(parts3[0] + "h " + parts3[1] + "min");
                }
            }
        }

        //if (pvm_tanaan == null || pvm_tanaan.matches (tanaan) == false) {
            //kestavyysluku.setText ("Et ole harjoitellut tänään kestävyyttä");
            //liikkuvuusluku.setText ("Et ole harjoitellut tänään liikkuvuutta");
            //lihasvoimaluku.setText ("Et ole harjoitellut tänään lihasvoimaa");
        //}
        //String kestavyys123 = tyyppi.get (tyyppi.size () -1);
       // Log.d ("viimeinen tyyppi",kestavyys123);
        //Log.d("TESTI",tyyppi.toString ());
       // Log.d("KESTO",kesto.toString ());
        //Log.d("pvm =", pvm.toString ());
        //Log.d("tanaan =", tanaan);
        //Log.d("Tyyppi SIZE", String.valueOf(koko) );
        return view;
    }

}