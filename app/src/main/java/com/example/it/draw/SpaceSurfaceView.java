package com.example.it.draw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class SpaceSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    int counter = 0;
    DrawThread dt;

    class DrawThread extends Thread
    {
        ArrayList<Bubble> bubbles = new ArrayList<>();
        boolean runFlag = true;
        SurfaceHolder surfaceHolder;

        public DrawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
            for (int i = 0; i < 100; i++) {
                bubbles.add(new Bubble());
            }
        }
        @Override
        public void run()
        {
            while (runFlag) {

                try {
                    sleep(2);
                }
                catch (InterruptedException e) {}
                Canvas canvas = surfaceHolder.lockCanvas(null);
                Paint p = new Paint();
                Random r = new Random();
                canvas.drawColor(Color.rgb(0,0,100));
                float center_x = canvas.getWidth()/2;
                float center_y = canvas.getHeight()/2;

                p.setColor(Color.WHITE);
                for (Bubble b : bubbles)
                {
                    b.step();
                    canvas.drawCircle(b.getX()+ center_x, b.getY() + center_y, b.radius, p);
                }
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }

    }
    public SpaceSurfaceView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        getHolder().addCallback(this);
    }
    @Override
    public void surfaceCreated(final SurfaceHolder holder) {

        dt = new DrawThread(holder);
        dt.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (dt != null) {
            dt.runFlag = false;
            try {
                dt.join();
            } catch (InterruptedException e) { }
        }


    }

}
