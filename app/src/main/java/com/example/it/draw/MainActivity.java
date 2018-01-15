package com.example.it.draw;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    SpaceSurfaceView draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = (SpaceSurfaceView) findViewById(R.id.view);

    }

    @Override
    protected void onStop() {
        super.onStop();
        draw.dt.runFlag = false;

    }

    @Override
    protected void onPause() {
        super.onPause();
        draw.dt.runFlag = false;
    }

    public void onClick(View v)
    {
        draw.dt.runFlag = false;
    }
}

