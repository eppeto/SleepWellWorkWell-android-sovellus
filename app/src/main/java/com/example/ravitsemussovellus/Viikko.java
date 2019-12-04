package com.example.ravitsemussovellus;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Viikko extends Fragment implements SearchView.OnQueryTextListener {


    public Viikko() {
        // Required empty public constructor
    }
    DateFormat df = new SimpleDateFormat ("dd.MM.yy");
    String tanaan = df.format(Calendar.getInstance().getTime());

    private Date tanaan_1() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    private Date tanaan_2() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        return cal.getTime();
    }
    private Date tanaan_3() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);
        return cal.getTime();
    }
    private Date tanaan_4() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -4);
        return cal.getTime();
    }
    private Date tanaan_5() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -5);
        return cal.getTime();
    }
    private Date tanaan_6() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -6);
        return cal.getTime();
    }
    private String getTanaan_1() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(tanaan_1 ());
    }
    private String getTanaan_2() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(tanaan_2 ());
    }
    private String getTanaan_3() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(tanaan_3 ());
    }
    private String getTanaan_4() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(tanaan_4 ());
    }
    private String getTanaan_5() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(tanaan_5 ());
    }
    private String getTanaan_6() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        return dateFormat.format(tanaan_6 ());
    }

    public List<Integer> liikunta_id = new ArrayList<Integer> ();
    public List<String> tyyppi = new ArrayList<String> ();
    public List<String> pvm = new ArrayList<String> ();
    public List<String> kesto = new ArrayList<String> ();

    public int ruokailu_id;
    public int maara_ruoka;
    public Date pvm_ruoka;
    public String kello_ruoka;

    public int unistressi_id;
    public int unilaatu;
    public int stressi;
    public Date pvm_unistressi;

    LineChart lineChart;
    LineData lineData1;
    LineData lineData2;
    LineData lineData3;
    LineData lineData4;
    ArrayList dataSets = new ArrayList <>();
    LineDataSet lineDataSet;
    Description description = new Description ();
    public void drawLineChartLineLiikunta(){

        float[] yDataL = {10, 20, 30, 40, 50, 60, 70};
        final String[] xDataL = { getTanaan_6 (), getTanaan_5 (), getTanaan_4 (), getTanaan_3 (), getTanaan_2 (), getTanaan_1 (), String.valueOf (tanaan)}; // Your List / array with String Values For X-axis Labels
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter (xDataL));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        final ArrayList<Entry> yEntrys = new ArrayList<>();
        final ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yDataL.length; i++){
            yEntrys.add(new Entry(i, yDataL[i]));
        }

        for (int i = 1; i < xDataL.length; i++){
            xEntrys.add(xDataL[i]);
        }

        lineDataSet = new LineDataSet(yEntrys, "LIIKUNTA");
        lineDataSet.setColor (Color.YELLOW);
        dataSets.add (lineDataSet);
        lineData1 = new LineData(dataSets);
        lineChart.setData(lineData1);
        lineChart.invalidate();
    }
    public void drawLineChartLineRuokailu(){

        float[] yDataL = {10, 35, 20, 50, 20, 10, 60};
        final String[] xDataL = { getTanaan_6 (), getTanaan_5 (), getTanaan_4 (), getTanaan_3 (), getTanaan_2 (), getTanaan_1 (), String.valueOf (tanaan)}; // Your List / array with String Values For X-axis Labels
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter (xDataL));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        final ArrayList<Entry> yEntrys = new ArrayList<>();
        final ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yDataL.length; i++){
            yEntrys.add(new Entry(i, yDataL[i]));
        }

        for (int i = 1; i < xDataL.length; i++){
            xEntrys.add(xDataL[i]);
        }

        lineDataSet = new LineDataSet(yEntrys, "RUOKAILU");
        lineDataSet.setColor (Color.RED);
        dataSets.add (lineDataSet);
        lineData2 = new LineData(dataSets);
        lineChart.setData(lineData2);
        lineChart.invalidate();
    }
    public void drawLineChartLineUni(){

        float[] yDataL = {10, 20, 20, 20, 30, 20, 10};
        final String[] xDataL = { getTanaan_6 (), getTanaan_5 (), getTanaan_4 (), getTanaan_3 (), getTanaan_2 (), getTanaan_1 (), String.valueOf (tanaan)}; // Your List / array with String Values For X-axis Labels
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter (xDataL));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        final ArrayList<Entry> yEntrys = new ArrayList<>();
        final ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yDataL.length; i++){
            yEntrys.add(new Entry(i, yDataL[i]));
        }

        for (int i = 1; i < xDataL.length; i++){
            xEntrys.add(xDataL[i]);
        }

        lineDataSet = new LineDataSet(yEntrys, "UNI");
        lineDataSet.setColor (Color.GREEN);
        dataSets.add (lineDataSet);
        lineData3 = new LineData(dataSets);
        lineChart.setData(lineData3);
        lineChart.invalidate();
    }
    public void drawLineChartLineStressi(){

        float[] yDataL = {20, 20, 20, 15, 20, 50, 20};
        final String[] xDataL = { getTanaan_6 (), getTanaan_5 (), getTanaan_4 (), getTanaan_3 (), getTanaan_2 (), getTanaan_1 (), String.valueOf (tanaan)}; // Your List / array with String Values For X-axis Labels
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter (xDataL));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        final ArrayList<Entry> yEntrys = new ArrayList<>();
        final ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < yDataL.length; i++){
            yEntrys.add(new Entry(i, yDataL[i]));
        }

        for (int i = 1; i < xDataL.length; i++){
            xEntrys.add(xDataL[i]);
        }

        lineDataSet = new LineDataSet(yEntrys, "STRESSI");
        lineDataSet.setColor (Color.BLUE);
        dataSets.add (lineDataSet);
        lineData4 = new LineData(dataSets);

        lineChart.setData(lineData4);
        lineChart.invalidate();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_viikko, container, false);
        lineChart = view.findViewById(R.id.lineChart);
        description.setText ("VIIKON TULOKSET");
        description.setTextSize (10);
        lineChart.setDescription (description);
        drawLineChartLineLiikunta ();
        drawLineChartLineRuokailu ();
        drawLineChartLineUni ();
        drawLineChartLineStressi ();

        Log.d ("LIIKUNNAN PVM", String.valueOf (pvm));
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