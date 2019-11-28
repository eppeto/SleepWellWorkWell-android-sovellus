package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

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
        return inflater.inflate(R.layout.fragment_paiva, container, false);
    }
}