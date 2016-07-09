package com.example.sharm_000.homework3;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements CoverPageFragment.OnButtonClickedListener, CoverPageFragment.OnFragmentInteractionListener, CoverPageFragment.OnTask2ButtonClickedListener, CoverPageFragment.OnTask3ButtonClickedListener
{
    //int counter;
    Fragment currentFragment;
    //static boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //flag=true;
        super.onCreate(savedInstanceState);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            if(getSupportFragmentManager().getFragment(savedInstanceState,"currentFrag") != null)
                    currentFragment = getSupportFragmentManager().getFragment(savedInstanceState,"currentFrag");
            else
                currentFragment = CoverPageFragment.newInstance();
        }
        else
            currentFragment = CoverPageFragment.newInstance();

        getSupportFragmentManager().beginTransaction().
            replace(R.id.maincontainer, currentFragment).commit();
    }

    @Override
    public void onButtonClicked(Bundle savedInstanceState) {
            currentFragment = AboutMeFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,
                    currentFragment).addToBackStack(null).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putInt("counter",counter);
        if(currentFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "currentFrag", currentFragment);
        }
    }

    @Override
    public void onTask2ButtonClick(Bundle savedInstanceState) {
        //flag=false;
        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTask3ButtonClick(Bundle savedInstanceState) {
        //flag=false;
        Intent intent = new Intent(this, MasterDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}