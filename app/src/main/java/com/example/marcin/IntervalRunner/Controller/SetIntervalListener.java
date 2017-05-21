package com.example.marcin.IntervalRunner.Controller;

import android.app.ActivityManager;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcin.IntervalRunner.Activities.MainActivity;
import com.example.marcin.IntervalRunner.View.StartScreenFragment;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * Created by Marcin on 16.04.2017.
 */

public class SetIntervalListener implements View.OnClickListener {

    private TextView inputSeconds;
    private TextView inputIterations;

    public SetIntervalListener(TextView inputSec){
        inputSeconds = inputSec;
    }
    @Override
    public void onClick (View view){
        String inputSecondsText = inputSeconds.getText().toString();

        if(inputSecondsText.isEmpty()){
            Toast.makeText(MainActivity.MainContext,"Type in some interval time (greater or equal 10)",Toast.LENGTH_SHORT).show();
            setToZero();
        }
        else if(TimerCounter.isRunning)
            Toast.makeText(MainActivity.MainContext,"Pause currently running interval",Toast.LENGTH_SHORT).show();
        else if(Integer.parseInt(inputSecondsText) >= 5)
            setup();
        else
            Toast.makeText(MainActivity.MainContext,"This interval is too short",Toast.LENGTH_SHORT).show();
    }
    private void setup(){
        Date time = new Date(Integer.parseInt(inputSeconds.getText().toString()) * 1000);
        SimpleDateFormat timeString = new SimpleDateFormat("m:ss");

        ImageButton startStopBtn = StartScreenFragment.getInstance().trainingStartStop_imgBtn;
        TextView displayedTime = StartScreenFragment.getInstance().intervalTimer_tv;

        displayedTime.setText(timeString.format(time));
        startStopBtn.setOnClickListener(new RunListener(startStopBtn,displayedTime));
    }
    private void setToZero(){
        Date time = new Date(0);
        SimpleDateFormat timeString = new SimpleDateFormat("m:ss");

        ImageButton startStopBtn = StartScreenFragment.getInstance().trainingStartStop_imgBtn;
        TextView displayedTime = StartScreenFragment.getInstance().intervalTimer_tv;

        displayedTime.setText(timeString.format(time));
        startStopBtn.setOnClickListener(new RunListener(startStopBtn,displayedTime));
    }
}
