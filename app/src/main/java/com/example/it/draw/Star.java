package com.example.it.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;


public class Star {
    public Star(int radius, int temperature, float x, float y) {
        this.radius = radius;
        this.temperature = temperature;
        this.x = x;
        this.y = y;
    }

    public static boolean isSorted(ArrayList<Star> stars) {
        // сравнить попарно объекты и проверить,
        // что они располагаются в порядке возрастания температуры
        return false;
    }
    static final int SUN_CANVAS_RADIUS = 20;
    static final int SUN_RADIUS = 695508; // km
    static final int SUN_TEMP = 6000; // K
    int temperature, radius; float x ,y;
    public int color() {
        if (temperature < 3000) return Color.rgb(153, 0, 0);
        if (temperature < 4500 && temperature >= 3000) return Color.RED;
        if (temperature < 6000 && temperature >= 4500) return Color.rgb(255,204,0);
        if (temperature < 8000 && temperature >= 6000) return Color.YELLOW;
        if (temperature < 10000 && temperature >= 8000) return Color.WHITE;
        if (temperature < 20000 && temperature >= 10000) return Color.rgb(0,102,255);
        if (temperature >= 20000) return Color.BLUE;
        // возврат цвета по температуре
        return Color.WHITE;
    }
    public int luminosity() {
        return (int)( Math.pow(radius/SUN_RADIUS,2)*Math.pow(temperature/SUN_TEMP,4));
        // зависимость светимости от температуры и радиуса
    }

    public void draw(Canvas c) {
        Paint p = new Paint(); p.setColor(color());
        c.drawCircle(x,y,radius/SUN_RADIUS * SUN_CANVAS_RADIUS, p);
    }



}
