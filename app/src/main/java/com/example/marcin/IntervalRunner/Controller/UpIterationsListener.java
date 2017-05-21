package com.example.marcin.IntervalRunner.Controller;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcin on 21.05.2017.
 */

public class UpIterationsListener implements View.OnClickListener {
    private TextView inputIterations;
    public UpIterationsListener(TextView inputIter){
        inputIterations = inputIter;
    }
    @Override
    public void onClick (View view){
        int iterations = Integer.parseInt(inputIterations.getText().toString());
        iterations += 1;
        inputIterations.setText(Integer.toString(iterations));
    }
}
