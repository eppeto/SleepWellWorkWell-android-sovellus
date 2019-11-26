package com.example.ravitsemussovellus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Viikko extends Fragment implements SearchView.OnQueryTextListener {

    public Viikko() {
        // Required empty public constructor
    }
    TextView liikuntatxt = (TextView) getActivity ().findViewById (R.id.txt_liikunta_col1);
    public void setText(String text){
        liikuntatxt.setText (text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // int liikunta_id = ((Raportit)this.getActivity()).liikunta_id;
       // TextView liikuntatxt = (TextView) getActivity ().findViewById (R.id.txt_liikunta_col1);

        return inflater.inflate(R.layout.fragment_viikko, container, false);


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