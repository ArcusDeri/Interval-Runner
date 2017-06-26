package com.example.marcin.IntervalRunner.Controller;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcin on 19.05.2017.
 */

public class UpHighPaceListener implements View.OnClickListener {
    private TextView inputSeconds;
    public UpHighPaceListener(TextView inputSec){
        inputSeconds = inputSec;
    }
    @Override
    public void onClick (View view){
        int seconds = Integer.parseInt(inputSeconds.getText().toString());
        seconds += 5;
        inputSeconds.setText(Integer.toString(seconds));
    }
}
