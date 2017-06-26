package com.example.marcin.IntervalRunner.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.marcin.IntervalRunner.Controller.DownIterationsListener;
import com.example.marcin.IntervalRunner.Controller.DownHighPaceListener;
import com.example.marcin.IntervalRunner.Controller.DownLowPaceListener;
import com.example.marcin.IntervalRunner.Controller.SetIntervalListener;
import com.example.marcin.IntervalRunner.Controller.UpIterationsListener;
import com.example.marcin.IntervalRunner.Controller.UpHighPaceListener;
import com.example.marcin.IntervalRunner.Controller.UpLowPaceListener;
import com.example.marcin.IntervalRunner.R;

/**
 * Created by Marcin on 03.05.2017.
 */

public class TrainingSettingsFragment extends Fragment {
    public TextView textView;
    private static TrainingSettingsFragment mInstance;

    public static TrainingSettingsFragment newInstance(){
        TrainingSettingsFragment tsf = new TrainingSettingsFragment();
        mInstance = tsf;
        return tsf;}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Bundle bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedIsntanceState){

        View view = inflater.inflate(R.layout.right_page,container,false);

        ImageButton highPaceUpArrowBtn = (ImageButton) view.findViewById(R.id.high_pace_up_imgbtn);
        ImageButton highPaceDownArrowBtn = (ImageButton) view.findViewById(R.id.high_pace_down_imgbtn);
        ImageButton lowPaceUpArrowBtn = (ImageButton) view.findViewById(R.id.low_pace_up_imgbtn);
        ImageButton lowPaceDownArrowBtn = (ImageButton) view.findViewById(R.id.low_pace_down_imgbtn);
        ImageButton iterationsDownArrowBtn= (ImageButton) view.findViewById(R.id.iterations_down_imgbtn);
        ImageButton iterationsUpArrowBtn= (ImageButton) view.findViewById(R.id.iterations_up_imgbtn);

        TextView highPaceInput = (TextView) view.findViewById(R.id.high_pace_seconds_tv);
        TextView lowPaceInput = (TextView) view.findViewById(R.id.low_pace_seconds_tv);
        TextView iterationsInput = (TextView) view.findViewById(R.id.iterationsTv);

        Button setIntervalButton = (Button) view.findViewById(R.id.set_interval_button);
        setIntervalButton.setOnClickListener(new SetIntervalListener(highPaceInput,lowPaceInput,iterationsInput));

        highPaceUpArrowBtn.setOnClickListener(new UpHighPaceListener(highPaceInput));
        highPaceDownArrowBtn.setOnClickListener(new DownHighPaceListener(highPaceInput));

        lowPaceUpArrowBtn.setOnClickListener(new UpLowPaceListener(lowPaceInput));
        lowPaceDownArrowBtn.setOnClickListener(new DownLowPaceListener(lowPaceInput));

        iterationsUpArrowBtn.setOnClickListener(new UpIterationsListener(iterationsInput));
        iterationsDownArrowBtn.setOnClickListener(new DownIterationsListener(iterationsInput));
        /*StartScreenFragment sf = StartScreenFragment.getInstance();
        Bundle bundle = sf.getArguments();
        Log.d("mrc", " " + bundle);*/
        return view;
    }
    public static synchronized TrainingSettingsFragment getInstance(){
        if(mInstance == null)
            mInstance = newInstance();

        /*Bundle bundle =  new Bundle();
        bundle.putString("sampel","chujowo");
        tf.setArguments(bundle);*/
        return mInstance;
    }
}
