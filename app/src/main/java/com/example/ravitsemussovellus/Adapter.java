package com.example.ravitsemussovellus;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;



class Adapter extends FragmentStatePagerAdapter {

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
                return new Paiva ();
            case 1:
                return new Viikko ();
            default:
                return null; // shouldn't happen
        }
    }
    @Override
    public int getCount() {
        return tabTitles.length;
    }
}