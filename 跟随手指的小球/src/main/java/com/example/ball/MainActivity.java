package com.example.ball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout root = (LinearLayout) findViewById(R.id.root);
//        final DrawView draw = new DrawView(this);
//        //设置自定义组件的最小宽度,高度
//        draw.setMinimumWidth(300);
//        draw.setMinimumHeight(300);
//        root.addView(draw);
    }
}
