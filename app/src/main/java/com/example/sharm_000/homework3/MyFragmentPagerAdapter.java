package com.example.sharm_000.homework3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by sharm_000 on 2/11/2016.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    int count;
    MovieData movieData = new MovieData();

    @Override
    public Fragment getItem(int position) {
        return MovieFragment.newInstance((HashMap<String,?>) movieData.getItem(position));
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        HashMap<String,?> movieMap = movieData.getItem(position);
        String name = (String) movieMap.get("name");

        return name.toUpperCase(l);
    }

    public MyFragmentPagerAdapter(FragmentManager fm, int size){
        super(fm);
        count = size;
    }
}
