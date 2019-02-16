package com.example.it.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class DiagramView extends View {
    ArrayList<Star> stars = new ArrayList<>();
    public DiagramView(Context context) {
        super(context);
        stars.add(new Star(700000, 20000, 200, 200));

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
        // добавить звузду со случайным радиусом и температурой
        // радиус от 0,01 до 1000 солнечного
        return true;
    }
}
