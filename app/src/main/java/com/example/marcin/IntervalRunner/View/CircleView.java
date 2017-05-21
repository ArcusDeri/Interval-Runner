package com.example.marcin.IntervalRunner.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;

/**
 * Created by Marcin on 09.04.2017.
 */

public class CircleView extends View {
    private static final int DEFAULT_DRAWING_COLOR = Color.RED;
    private int drawingColor = DEFAULT_DRAWING_COLOR;
    private double radius = 200;
    private int strokeWidth = 15;
    private float centerX = 0,centerY = 0;            //center of circle
    public Paint paint;

    public CircleView(Context context){
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
        //init(context, null);
    }/*
    public ShapeView(Context context,AttributeSet attrs){
        super(context);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs){
        paint = new Paint();
        paint.setAntiAlias(true);
    } */
    public void setPaintOptions(Paint.Style style,int color,int alpha){
        this.paint.setStyle(style);
        this.paint.setAlpha(alpha);
        this.paint.setColor(color);
    };
    public void setDrawingColor(int color){
        this.drawingColor = color;
        invalidate();
    }
    public int getDrawingColor(){
        return drawingColor;
    }
    public void setCircleRadius(double length){
        this.radius = length;
        invalidate();
    }
    public double getCircleRadius(){
        return radius;
    }
    public void setStrokeWidth(int width){
        this.strokeWidth = width;
        paint.setStrokeWidth(strokeWidth);
        invalidate();
    }
    public int getStrokeWidth(){return strokeWidth;}
    public void setCenterX(float x){
        this.centerX = x;
    }
    public void setCenterY(float y){
        this.centerY = y;
    }
    public double getCenterX(){
        return centerX;
    }
    public double getCenterY(){
        return centerY;
    }

    protected void onDraw(Canvas canvas){
        //super.onDraw(canvas);
        canvas.drawCircle(centerX,centerY,(float) radius,paint);
        canvas.drawCircle(540,410,1,paint);
        Log.d("mrc","Drawing circle color: " + Integer.toHexString(drawingColor) + " Radius: " + radius + " Center x,y: " + centerX +
                "," + centerY);
    }
}
