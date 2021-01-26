package com.example.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timer;
    Button start,stop;
    Button reset;
    boolean running;
    int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);
        running = false;
        runTimer();
    }

    public void onStartClick(View view){
        running = true;
        start.setVisibility(View.GONE);
        stop.setVisibility(View.VISIBLE);

    }

    public void onStopClick(View view){
        running = false;
        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }

    public void onResetClick(View view){
        running = false;
        seconds =0;
        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }

    public void runTimer(){

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds%60;

                String time = String.format("%d:%02d:%02d",hours,minutes,sec);
                timer.setText(time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this,800);
            }
        });

    }
}