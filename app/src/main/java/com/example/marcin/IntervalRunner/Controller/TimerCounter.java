package com.example.marcin.IntervalRunner.Controller;
import android.media.MediaPlayer;

import com.example.marcin.IntervalRunner.Activities.MainActivity;
import com.example.marcin.IntervalRunner.R;
import com.example.marcin.IntervalRunner.Utils.AccurateCountDownTimer;
import com.example.marcin.IntervalRunner.View.StartScreenFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marcin on 17.04.2017.
 */

public class TimerCounter extends AccurateCountDownTimer{
    public static boolean isRunning,isCompleted;

    private long secondsToGo;
    private int iterations;
    private StartScreenFragment startScreen;

    public TimerCounter(long millisInFuture,int iterations, long countDownInterval ){
        super(millisInFuture, countDownInterval);
        this.secondsToGo = millisInFuture;
        this.iterations = iterations;
    }

    public void pause(){
        isRunning = false;
        cancel();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        secondsToGo = Math.round((float)millisUntilFinished/1000)*1000;
        Date time = new Date(secondsToGo);
        SimpleDateFormat format = new SimpleDateFormat("m:ss");

        startScreen.intervalTimer_tv.setText(format.format(time));
    }

    @Override
    public void onFinish() {
        startScreen.intervalTimer_tv.setText("0:00");
        if(iterations > 1){
            RunListener.getInstance().iterations--;
            MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.MainContext, R.raw.pace_change_sound);
            mediaPlayer.start();
            RunListener.getInstance().countNextIteration();
        }else{
            isRunning = false;
            isCompleted = true;
            RunListener.getInstance().switchIsClicked();
            RunListener.getInstance().setButtonIcon();
            MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.MainContext, R.raw.finish_training);
            mediaPlayer.start();
            startScreen.paceText_tv.setText("");
        }
    }

    public void startCounting()
    {
        startScreen = StartScreenFragment.getInstance();
        start();
    }
    public int getMilisLeft(){return (int) secondsToGo;}
}
