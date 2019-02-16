package com.example.it.draw;

import java.util.Random;


public class Bubble {
    float radius, distance, angle, velocity;
    Bubble()
    {
        Random r = new Random();
        distance = 10f + r.nextFloat()*50;
        radius = 1f + r.nextFloat()*10;

        angle = r.nextFloat()* 2 * (float)Math.PI;
        velocity = r.nextFloat()/10 + 1;
    }
    void step()
    {
        if (distance > 0 && distance < 300)
            distance *= 1 + distance / 1000;
        else
        {
            Random r = new Random();
            distance = 10f;
            angle = r.nextFloat()*(float) 6.28;
            velocity = r.nextFloat() + 1;
        }
    }
    float getX() {
        return  (float)(distance *Math.cos(angle));
    }; // возвращает текущее значение координаты X на канве
    float getY(){

        return  (float)(distance *Math.sin(angle));
    }; // возвращает текущее значение координаты Y на канве
}
