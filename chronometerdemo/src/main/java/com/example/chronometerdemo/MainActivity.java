package com.example.chronometerdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer ch;
    private Button start;
    private Button stop;
    private Button reset;
    Boolean recorder = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        reset = (Button) findViewById(R.id.reset);
        ch = (Chronometer) findViewById(R.id.ch);
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                start.setEnabled(true);
            }
        });
    }

    public void onStart(View view) {
        if (recorder) {
            recorder = false;
            ch.stop();
            start.setText("开始记时");
        } else {
            recorder = true;
            ch.setBase(SystemClock.elapsedRealtime());
            ch.start();
            start.setText("结束记时");
        }
    }

    public void onStop(View view) {
        if (recorder) {
            recorder = false;
            ch.stop();
            stop.setText("继续记时");
        } else {
            recorder = true;
            ch.start();
            stop.setText("暂停记时");
        }
    }

    public void onReset(View view) {
        ch.setBase(SystemClock.elapsedRealtime());
    }
}
