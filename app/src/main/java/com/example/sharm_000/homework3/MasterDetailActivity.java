package com.example.sharm_000.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.HashMap;

public class MasterDetailActivity extends AppCompatActivity implements MasterListFragment.OnButtonClickedListener{

    private boolean twoPane=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.masterDetailView,MasterListFragment.newInstance()).commit();
        }
        if(findViewById(R.id.detailContainer)!=null){
            twoPane=true;
        }
    }

    @Override
    public void onButtonClicked(int id) {
        MovieData movieData = new MovieData();
        Button buttonMovie = (Button)findViewById(id);
        String movieName =  (String)buttonMovie.getText();
        int i=0;
        switch (movieName)
        {
            case "Avatar":
                i=0;
                break;
            case "Titanic":
                i=1;
                break;
            case "The Avengers":
                i=2;
                break;
            case "The Dark Knight":
                i=3;
                break;
            case "Star Wars I":
                i=4;
                break;
            default:
                i=4;
        }
        if(twoPane==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer,MovieFragment.newInstance((HashMap<String,?>)movieData.getItem(i)))
                    .addToBackStack(null).commit();
        }
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.masterDetailView,MovieFragment.newInstance((HashMap<String,?>)movieData.getItem(i)))
                    .addToBackStack(null).commit();
        }
        }
    }
