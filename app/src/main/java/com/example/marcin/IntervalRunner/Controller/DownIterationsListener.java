package com.example.marcin.IntervalRunner.Controller;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Marcin on 21.05.2017.
 */

public class DownIterationsListener implements View.OnClickListener {
    private TextView inputIterations;
    public DownIterationsListener(TextView inputIter){
        inputIterations = inputIter;
    }
    @Override
    public void onClick (View view){
        int iterations = Integer.parseInt(inputIterations.getText().toString());

        iterations -= iterations > 1 ? 1 : 0;
        inputIterations.setText(Integer.toString(iterations));
    }
}
