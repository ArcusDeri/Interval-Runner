package com.example.marcin.IntervalRunner.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.marcin.IntervalRunner.View.StartScreenFragment;
import com.example.marcin.IntervalRunner.View.TrainingSettingsFragment;

/**
 * Created by Marcin on 01.05.2017.
 */

public class MenuPagerAdapter extends FragmentPagerAdapter {

    public MenuPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int i){
        switch (i){
            case 0:
                return TrainingSettingsFragment.newInstance();
            case 1:
                return StartScreenFragment.newInstance();
            case 2:
                return TrainingSettingsFragment.newInstance();
            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position){
        return "Object " + (position + 1);
    }
}

