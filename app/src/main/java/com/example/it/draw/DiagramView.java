package com.example.it.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;


public class DiagramView extends View {
    ArrayList<Star> stars = new ArrayList<>();
    public DiagramView(Context context) {
        super(context);
        stars.add(new Star(700000, 8000, 200, 200));

    }
    public void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.rgb(0, 0, 40));
        for (Star s : stars) {
            s.draw(c);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // добавить звезду со случайным радиусом и температурой
        // радиус от 0,01 до 1000 солнечного
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        Random r = new Random();
        int radius = (int) (r.nextDouble()*Star.SUN_RADIUS);
        int temp = r.nextInt(40000)+2000;
        stars.add(new Star(radius, temp, event.getX(), event.getY()));
        invalidate();
        Log.d("my", "added star r = "+ radius +" at " + event.getX() + " " + event.getY());
        Log.d("my", "total stars  " +stars.size() );
        return true;
    }
}
