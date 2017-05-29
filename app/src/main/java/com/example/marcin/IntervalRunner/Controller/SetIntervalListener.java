package com.example.marcin.IntervalRunner.Controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcin.IntervalRunner.Activities.MainActivity;
import com.example.marcin.IntervalRunner.View.StartScreenFragment;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Marcin on 16.04.2017.
 */

public class SetIntervalListener implements View.OnClickListener {

    private TextView _inputSeconds;
    private TextView _inputIterations;

    public SetIntervalListener(TextView inputSec,TextView inputIter){
        _inputSeconds = inputSec;
        _inputIterations = inputIter;
    }
    @Override
    public void onClick (View view){
        checkIfCanSetInterval();
    }
    private void setup(int milisToGo){
        int iterationsNumber = Integer.parseInt(_inputIterations.getText().toString());
        StartScreenFragment startScreenFragment = StartScreenFragment.getInstance();


        ImageButton startStopBtn = startScreenFragment.trainingStartStop_imgBtn;
        TextView displayedTime = startScreenFragment.intervalTimer_tv;

        RunListener rListener = new RunListener(startStopBtn,displayedTime);
        startStopBtn.setOnClickListener(rListener);
        rListener.miliSecondsToCount = milisToGo;
        rListener.initialTime = milisToGo;
        rListener.iterations = iterationsNumber;
        rListener.setOriginValue(milisToGo);
    }

    private void checkIfCanSetInterval(){
        String inputSecondsText = _inputSeconds.getText().toString();
        int inputTime = Integer.parseInt(inputSecondsText);

        if(TimerCounter.isRunning) {
            Toast.makeText(MainActivity.MainContext, "Pause currently running interval", Toast.LENGTH_SHORT).show();
        }
        else if(inputTime < 5) {
            Toast.makeText(MainActivity.MainContext,"This interval is too short",Toast.LENGTH_SHORT).show();
        }
        else
            setup(inputTime * 1000);
    }
}
