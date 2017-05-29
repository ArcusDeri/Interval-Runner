package com.example.marcin.IntervalRunner.Controller;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcin.IntervalRunner.Activities.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.marcin.IntervalRunner.R.drawable.pause_button;
import static com.example.marcin.IntervalRunner.R.drawable.play_button;

/**
 * Created by Marcin on 16.04.2017.
 */

public class RunListener implements View.OnClickListener {
    private float _scale;
    private int _leftPaddingDP, _rightPaddingDP, _bottomPaddingDP, _topPaddingDP;
    private boolean _isClicked = false;
    private ImageButton _imageButton;
    private TextView _intervalTextView;
    private TimerCounter _timerCounter;

    private static RunListener RunListener;

    public int miliSecondsToCount;
    public int initialTime;
    public int iterations = 1;

    public RunListener(ImageButton imgBtn,TextView intervalTv){
        RunListener = this;
        this._imageButton = imgBtn;
        this._intervalTextView = intervalTv;
        this._scale = MainActivity.MainContext.getResources().getDisplayMetrics().density;
    }

    @Override
    public void onClick (View view){
        if(!_intervalTextView.getText().toString().equals("0:00")) {
            _isClicked = !_isClicked;
            setButtonIcon();
            manageCounter();
        }
        else
            Toast.makeText(MainActivity.MainContext,"Set interval first",Toast.LENGTH_SHORT).show();
    }
    public void manageCounter(){
        if(_timerCounter != null){
            if(_isClicked){
                _timerCounter = new TimerCounter(miliSecondsToCount,iterations,1000,_intervalTextView);
                _timerCounter.startCounting();
            }
            else {
                _timerCounter.pause();
            }
        }else{
            _timerCounter = new TimerCounter(miliSecondsToCount,iterations,1000,_intervalTextView);
            _timerCounter.startCounting();
        }
    }
    public void countNextIteration(){
        _timerCounter = new TimerCounter(initialTime + 1000,iterations,1000,_intervalTextView);
        _timerCounter.startCounting();
    }
    public void setButtonIcon(){
        if(_isClicked){
            _leftPaddingDP = Math.round(20 * _scale);
            _topPaddingDP = Math.round(10 * _scale);
            _rightPaddingDP = Math.round(20 * _scale);
            _bottomPaddingDP = _topPaddingDP;

            _imageButton.setImageResource(pause_button);
            _imageButton.setPadding(_leftPaddingDP, _topPaddingDP, _rightPaddingDP, _bottomPaddingDP);
        }
        else{
            _leftPaddingDP = Math.round(25 * _scale);
            _topPaddingDP = Math.round(10 * _scale);
            _rightPaddingDP = Math.round(20 * _scale);
            _bottomPaddingDP = _topPaddingDP;

            _imageButton.setImageResource(play_button);
            _imageButton.setPadding(_leftPaddingDP, _topPaddingDP, _rightPaddingDP, _bottomPaddingDP);
        }
    }

    public void setOriginValue(int timeLeft){
        SimpleDateFormat format = new SimpleDateFormat("m:ss");
        Date time = new Date(timeLeft);
        _intervalTextView.setText(format.format(time));
    }
    public void switchIsClicked(){
        _isClicked = !_isClicked;
    }
    public static RunListener getInstance(){
        return  RunListener;
    }
}
