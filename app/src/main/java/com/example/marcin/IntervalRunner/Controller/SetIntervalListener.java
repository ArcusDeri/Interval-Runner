package com.example.marcin.IntervalRunner.Controller;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcin.IntervalRunner.Activities.MainActivity;
import com.example.marcin.IntervalRunner.View.StartScreenFragment;


/**
 * Created by Marcin on 16.04.2017.
 */

public class SetIntervalListener implements View.OnClickListener {

    private TextView _inputHighSeconds;
    private TextView _inputLowSeconds;
    private TextView _inputIterations;

    public SetIntervalListener(TextView inputHigh,TextView inputLow, TextView inputIter){
        _inputHighSeconds = inputHigh;
        _inputLowSeconds = inputLow;
        _inputIterations = inputIter;
    }
    @Override
    public void onClick (View view){
        checkIfCanSetInterval();
    }
    private void setup(int highPaceSeconds, int lowPaceSeconds){
        int iterationsNumber = Integer.parseInt(_inputIterations.getText().toString());
        StartScreenFragment startScreenFragment = StartScreenFragment.getInstance();


        ImageButton startStopBtn = startScreenFragment.trainingStartStop_imgBtn;
        TextView displayedTime = startScreenFragment.intervalTimer_tv;

        RunListener rListener = new RunListener(startStopBtn,displayedTime);
        startStopBtn.setOnClickListener(rListener);
        rListener.highPaceSecondsToCount = highPaceSeconds;
        rListener.lowPaceSecondsToCount = lowPaceSeconds;
        rListener.initialTime = lowPaceSeconds;
        rListener.iterations = iterationsNumber;
        rListener.setOriginValue(highPaceSeconds);
    }

    private void checkIfCanSetInterval(){
        String inputHighSecondsText = _inputHighSeconds.getText().toString();
        String inputLowSecondsText = _inputLowSeconds.getText().toString();
        int inputHighTime = Integer.parseInt(inputHighSecondsText);
        int inputLowTime = Integer.parseInt(inputLowSecondsText);

        if(TimerCounter.isRunning) {
            Toast.makeText(MainActivity.MainContext, "Pause currently running interval", Toast.LENGTH_SHORT).show();
        }
        else if(inputHighTime < 5 || inputLowTime < 5) {
            Toast.makeText(MainActivity.MainContext,"This interval is too short",Toast.LENGTH_SHORT).show();
        }
        else
            setup(inputHighTime * 1000,inputLowTime * 1000);
    }
}
