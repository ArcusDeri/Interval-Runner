package com.example.marcin.IntervalRunner.Controller;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcin on 21.05.2017.
 */

public class UpLowPaceListener implements View.OnClickListener {
    private TextView inputSeconds;
    public UpLowPaceListener(TextView inputIter){
        inputSeconds = inputIter;
    }
    @Override
    public void onClick (View view){
        int seconds = Integer.parseInt(inputSeconds.getText().toString());
        seconds += 5;
        inputSeconds.setText(Integer.toString(seconds));
    }
}
