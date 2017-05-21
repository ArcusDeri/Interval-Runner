package com.example.marcin.IntervalRunner.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.marcin.IntervalRunner.Activities.MainActivity;
import com.example.marcin.IntervalRunner.Controller.DownSecondsListener;
import com.example.marcin.IntervalRunner.Controller.SetIntervalListener;
import com.example.marcin.IntervalRunner.Controller.UpSecondsListener;
import com.example.marcin.IntervalRunner.R;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Marcin on 03.05.2017.
 */

public class TrainingSettingsFragment extends Fragment {
    public TextView textView;

    public static TrainingSettingsFragment newInstance(){return new TrainingSettingsFragment();}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Bundle bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedIsntanceState){

        View view = inflater.inflate(R.layout.right_page,container,false);
        Button setIntervalButton = (Button) view.findViewById(R.id.set_interval_button);
        ImageButton secondsUpArrowBtn = (ImageButton) view.findViewById(R.id.seconds_up_imgbtn);
        ImageButton secondsDownArrowBtn = (ImageButton) view.findViewById(R.id.seconds_down_imgbtn);
        TextView secondsInput = (TextView) view.findViewById(R.id.secondsTv);

        setIntervalButton.setOnClickListener(new SetIntervalListener(secondsInput));
        secondsUpArrowBtn.setOnClickListener(new UpSecondsListener(secondsInput));
        secondsDownArrowBtn.setOnClickListener(new DownSecondsListener(secondsInput));
        /*StartScreenFragment sf = StartScreenFragment.getInstance();
        Bundle bundle = sf.getArguments();
        Log.d("mrc", " " + bundle);*/
        return view;
    }
    public static TrainingSettingsFragment getInstance(){
        TrainingSettingsFragment tf = newInstance();

        /*Bundle bundle =  new Bundle();
        bundle.putString("sampel","chujowo");
        tf.setArguments(bundle);*/
        return tf;
    }
}
