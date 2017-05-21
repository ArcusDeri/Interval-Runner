package com.example.marcin.IntervalRunner.Controller;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcin.IntervalRunner.Activities.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.marcin.IntervalRunner.R.drawable.pause_button;
import static com.example.marcin.IntervalRunner.R.drawable.play_button;

/**
 * Created by Marcin on 16.04.2017.
 */

public class RunListener implements View.OnClickListener {
    private ImageButton imageButton;
    private boolean isClicked;
    private TextView timeTv;
    private TimerCounter counter;
    private Date time;
    private SimpleDateFormat timeString;
    private int milisecondsToCount;
    private int minutesFromView;
    private int secondsFromView;
    private float scale;
    private int leftPaddingDP;
    private int topPaddingDP;
    private int rightPaddingDP;
    private int bottomPaddingDP;

    public RunListener(ImageButton button, TextView timeTv){
        this.imageButton = button;
        this.timeTv = timeTv;
        this.isClicked = true;

        this.minutesFromView = Integer.parseInt(timeTv.getText().toString().substring(0,1));
        this.secondsFromView = Integer.parseInt(timeTv.getText().toString().substring(2,4));
        Log.d("mrc", timeTv.getText().toString().substring(2,4));
        this.milisecondsToCount = (minutesFromView * 60 + secondsFromView) * 1000;

        this.counter = new TimerCounter(timeTv,milisecondsToCount,1000);
        this.counter.setCaller(this);
        setOriginValue(milisecondsToCount);
        scale  = MainActivity.MainContext.getResources().getDisplayMetrics().density;
    }
    public void setOriginValue(int timeLeft){
        time = new Date(timeLeft);
        timeString = new SimpleDateFormat("m:ss");

        timeTv.setText(timeString.format(time));
    }

    @Override
    public void onClick (View view){
        String displayedTime = timeTv.getText().toString();
        minutesFromView = Integer.parseInt(displayedTime.substring(0,1));
        secondsFromView = Integer.parseInt(displayedTime.substring(2,4));

        if(timeTv.getText().toString().equals("0:00")){
            Toast.makeText(MainActivity.MainContext,"Set some interval first :)",Toast.LENGTH_SHORT).show();
        }

        this.milisecondsToCount = (minutesFromView * 60 + secondsFromView) * 1000;

        setOriginValue(counter.getMilisLeft());
        if(counter.getCompletedStatus()){
            setOriginValue(this.milisecondsToCount);
            counter = new TimerCounter(timeTv,this.milisecondsToCount,1000);
            counter.setCaller(this);
            counter.startCounting();
        }else if(isClicked)
            counter.startCounting();
            else{
                counter.cancel();
                counter = new TimerCounter(timeTv,counter.getMilisLeft(),1000);
                counter.setCaller(this);
                setOriginValue(counter.getMilisLeft());
            }
        setButtonIcon();
    }
    public void setButtonIcon(){
        if(isClicked){
            leftPaddingDP = Math.round(20 * scale);
            topPaddingDP = Math.round(10 * scale);
            rightPaddingDP = Math.round(20 * scale);
            bottomPaddingDP = topPaddingDP;

            imageButton.setImageResource(pause_button);
            imageButton.setPadding(leftPaddingDP,topPaddingDP,rightPaddingDP,bottomPaddingDP);
        }else{
            leftPaddingDP = Math.round(25 * scale);
            topPaddingDP = Math.round(10 * scale);
            rightPaddingDP = Math.round(20 * scale);
            bottomPaddingDP = topPaddingDP;

            imageButton.setImageResource(play_button);
            imageButton.setPadding(leftPaddingDP,topPaddingDP,rightPaddingDP,bottomPaddingDP);
        }
        isClicked = !isClicked;
    }
}
