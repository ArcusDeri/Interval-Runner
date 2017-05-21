package com.example.marcin.IntervalRunner.Controller;
import android.widget.TextView;

import com.example.marcin.IntervalRunner.Utils.AccurateCountDownTimer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marcin on 17.04.2017.
 */

public class TimerCounter {
    public static boolean isRunning = false;
    private AccurateCountDownTimer counter;
    private RunListener caller;
    private SimpleDateFormat timeString;
    private boolean isCompleted;
    private int miliTicks;

    public TimerCounter(final TextView textView,long inFuture,long interval){
            this.miliTicks = (int) inFuture;
            this.isCompleted = false;
            this.counter = new AccurateCountDownTimer(inFuture,interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                miliTicks = Math.round((float)millisUntilFinished/1000)*1000;
                Date time = new Date(miliTicks);
                timeString = new SimpleDateFormat("m:ss");

                textView.setText(timeString.format(time));
                isRunning = true;
                //Log.d("mrc","tick " + minutes + " " + seconds + " " + miliTicks);
            }

            @Override
            public void onFinish() {
                textView.setText("0:00");
                isCompleted = true;
                isRunning = false;
                caller.setButtonIcon();
            }
        };
    }
    public void cancel(){
        isRunning = false;
        counter.cancel();
    }
    public void startCounting(){
        counter.start();
    }
    public void setCaller(RunListener runListener){
        this.caller = runListener;
    }
    public int getMilisLeft(){return miliTicks;}
    public boolean getCompletedStatus(){return isCompleted;};
}