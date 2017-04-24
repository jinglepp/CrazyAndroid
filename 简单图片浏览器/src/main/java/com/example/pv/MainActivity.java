package com.example.pv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{
            R.drawable.t1,
            R.drawable.t2,
            R.drawable.t3,
            R.drawable.t4,
            R.drawable.t5
    };
    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.title);
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        final ImageView iv = new ImageView(this);

        main.addView(iv);
        //初始化时显示第一张图片
        iv.setImageResource(images[0]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iv.setImageResource(images[++currentImg % images.length]);
                currentImg = ++currentImg % images.length;
                iv.setImageResource(images[currentImg]);
                tv.setText("t" + (currentImg + 1) + ".jpg");
            }
        });
    }
}
