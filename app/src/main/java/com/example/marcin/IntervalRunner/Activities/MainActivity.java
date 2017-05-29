package com.example.marcin.IntervalRunner.Activities;

import android.app.DialogFragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

import com.example.marcin.IntervalRunner.Utils.MenuPagerAdapter;
import com.example.marcin.IntervalRunner.R;
import com.example.marcin.IntervalRunner.View.TrainingSettingsFragment;

public class MainActivity extends FragmentActivity {
    public static Context MainContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MenuPagerAdapter menuPagerAdapter;
        ViewPager viewPager;
        MainContext = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager);
        Log.i("mrc","App started");

        //myAdapter
        menuPagerAdapter = new MenuPagerAdapter(getSupportFragmentManager());

        //myPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(menuPagerAdapter);
        viewPager.setCurrentItem(1);

    }
}

