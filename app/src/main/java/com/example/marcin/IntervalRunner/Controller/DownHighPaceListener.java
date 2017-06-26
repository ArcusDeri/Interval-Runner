package com.example.marcin.IntervalRunner.Controller;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcin on 19.05.2017.
 */

public class DownHighPaceListener implements View.OnClickListener {
    private TextView inputSeconds;
    public DownHighPaceListener(TextView inputSec){
        inputSeconds = inputSec;
    }
    @Override
    public void onClick (View view){
        int seconds = Integer.parseInt(inputSeconds.getText().toString());
        if(seconds >= 5)
            seconds -= 5;
        inputSeconds.setText(Integer.toString(seconds));
    }
}
