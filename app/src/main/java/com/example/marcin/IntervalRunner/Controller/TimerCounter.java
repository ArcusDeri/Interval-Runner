package com.example.marcin.IntervalRunner.Controller;
import android.util.Log;
import android.widget.TextView;

import com.example.marcin.IntervalRunner.Utils.AccurateCountDownTimer;
import com.example.marcin.IntervalRunner.View.StartScreenFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marcin on 17.04.2017.
 */

public class TimerCounter extends AccurateCountDownTimer{
    public static boolean isRunning,isCompleted;

    private long milisToGo;
    private int iterations;
    private StartScreenFragment startScreen;

    public TimerCounter(long millisInFuture,int iterations, long countDownInterval,final TextView textView){
        super(millisInFuture, countDownInterval);
        this.milisToGo = millisInFuture;
        this.iterations = iterations;
    }

    public void pause(){
        isRunning = false;
        RunListener.getInstance().miliSecondsToCount =(int) milisToGo;
        cancel();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        milisToGo = Math.round((float)millisUntilFinished/1000)*1000;
        Date time = new Date(milisToGo);
        SimpleDateFormat format = new SimpleDateFormat("m:ss");

        startScreen.intervalTimer_tv.setText(format.format(time));
    }

    @Override
    public void onFinish() {
        startScreen.intervalTimer_tv.setText("0:00");
        if(iterations > 1){
            RunListener.getInstance().iterations--;
            RunListener.getInstance().countNextIteration();
        }else{
            isRunning = false;
            isCompleted = true;
            RunListener.getInstance().switchIsClicked();
            RunListener.getInstance().setButtonIcon();
        }
    }

    public void startCounting()
    {
        startScreen = StartScreenFragment.getInstance();
        start();
    }

    public int getMilisLeft(){return (int)milisToGo;}
}
