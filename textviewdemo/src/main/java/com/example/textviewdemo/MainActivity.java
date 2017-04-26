package com.example.textviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.custum_textview);
    }

    public void onClick(View view) {
        Log.d("LEE", "onClick");
        CheckedTextView ctv = (CheckedTextView) view;
        ctv.toggle();
        if (ctv.isChecked()) {
            ctv.setTextColor(Color.parseColor("#FF4081"));
            ctv.setCheckMarkDrawable(R.drawable.ok);
        } else {
            ctv.setTextColor(Color.GRAY);
            ctv.setCheckMarkDrawable(null);
        }
    }
}
