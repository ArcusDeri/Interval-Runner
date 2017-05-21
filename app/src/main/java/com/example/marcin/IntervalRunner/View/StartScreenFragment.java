package com.example.marcin.IntervalRunner.View;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.marcin.IntervalRunner.Controller.RunListener;
import com.example.marcin.IntervalRunner.R;

/**
 * Created by Marcin on 03.05.2017.
 */

public class StartScreenFragment extends Fragment {
    public static StartScreenFragment mInstance = null;
    public TextView intervalTimer_tv;
    public ImageButton trainingStartStop_imgBtn;

    public static StartScreenFragment newInstance(){
        StartScreenFragment startScreenFragment = new StartScreenFragment();
        mInstance = startScreenFragment;
        return startScreenFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_main,container,false);
        intervalTimer_tv =(TextView) view.findViewById(R.id.timeView);
        trainingStartStop_imgBtn = (ImageButton) view.findViewById(R.id.runButton);

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        setupAndStyle();
    }

    private void setupAndStyle(){

        trainingStartStop_imgBtn.setOnClickListener(new RunListener(trainingStartStop_imgBtn,intervalTimer_tv));

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int pl = getView().getPaddingLeft();
        int pr = getView().getPaddingRight();
        int pt = getView().getPaddingTop();
        int pb = getView().getPaddingBottom();
        int statusBarHeight = (int) Math.ceil(25 * this.getResources().getDisplayMetrics().density);
        int usableWidth = size.x - pl - pr;
        int usableHeight = size.y - pt - pb - statusBarHeight;

        CircleView centerCircle = new CircleView(getContext());
        centerCircle.setCenterX(usableWidth / 2);
        centerCircle.setCenterY((float) (usableHeight / 4.5));
        centerCircle.setPaintOptions(Paint.Style.STROKE, ResourcesCompat.getColor(getResources(),R.color.colorPrimaryDark,null),0xFF);
        centerCircle.setStrokeWidth(13);
        centerCircle.setCircleRadius(usableWidth / 3.5);

        ConstraintLayout main_cl = (ConstraintLayout) getView();
        main_cl.addView(centerCircle);
    }
    public static synchronized StartScreenFragment getInstance(){
        if(mInstance == null)
            mInstance = newInstance();

        return mInstance;
    }
}
