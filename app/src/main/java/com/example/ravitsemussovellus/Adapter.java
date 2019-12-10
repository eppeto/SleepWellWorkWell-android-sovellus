package com.example.ravitsemussovellus;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Adapter extends FragmentStatePagerAdapter {
    public List<Integer> liikunta_id = new ArrayList<Integer> ();
    public List<String> tyyppi = new ArrayList<String> ();
    public List<String> pvm = new ArrayList<String> ();
    public List<String> kesto = new ArrayList<String> ();

    public int ruokailu_id;
    public int maara_ruoka;
    public List<String> pvm_ruoka = new ArrayList<String>();
    public List<String> kello_ruoka = new ArrayList<String>();

    public int unistressi_id;
    public String unilaatu;
    public String stressi;
    public Date pvm_unistressi;

    LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    ArrayList lineEntries;

    public Context context;
    // tab titles
    private String[] tabTitles = new String[]{"Päivänäkymä", "Viikkonäkymä"};


    public Adapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Paiva p = new Paiva ();
                p.liikunta_id = liikunta_id;
                p.tyyppi = tyyppi;
                p.pvm = pvm;
                p.kesto = kesto;
                p.ruokailu_id = ruokailu_id;
                p.maara_ruoka = maara_ruoka;
                p.pvm_ruoka = pvm_ruoka;
                p.kello_ruoka = kello_ruoka;
                p.unistressi_id = unistressi_id;
                p.unilaatu = unilaatu;
                p.stressi = stressi;
                p.pvm_unistressi = pvm_unistressi;

                return p;
            case 1:
                Viikko v = new Viikko ();
                v.liikunta_id = liikunta_id;
                v.tyyppi = tyyppi;
                v.pvm = pvm;
                v.kesto = kesto;
                v.ruokailu_id = ruokailu_id;
                v.maara_ruoka = maara_ruoka;
                v.pvm_ruoka = pvm_ruoka;
                v.kello_ruoka = kello_ruoka;
                v.unistressi_id = unistressi_id;
                v.unilaatu = unilaatu;
                v.stressi = stressi;
                v.pvm_unistressi = pvm_unistressi;

                return v;
            default:
                return null; // shouldn't happen
        }
    }
    @Override
    public int getCount() {
        return tabTitles.length;
    }
}