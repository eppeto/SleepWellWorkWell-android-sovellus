package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class Viikko extends Fragment implements SearchView.OnQueryTextListener {


    public Viikko() {
        // Required empty public constructor
    }


    //TextView liikuntatxt = getActivity ().findViewById (R.id.txt_liikunta_col1);
    //public void setText(String text){
    //    liikuntatxt.setText (liikunta_id);
    //}

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
       // int liikunta_id = ((Raportit)this.getActivity()).liikunta_id;
       // TextView liikuntatxt = (TextView) getActivity ().findViewById (R.id.txt_liikunta_col1);
        Log.d ("testi", "LIIKUNTA ID =" + liikunta_id);

        View view = inflater.inflate(R.layout.fragment_viikko, container, false);
        TextView txtview_liikunta_id = (TextView) view.findViewById (R.id.txt_liikunta_col1);

        txtview_liikunta_id.setText (kesto);

        return view;



    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}