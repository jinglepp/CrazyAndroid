package com.example.layoutdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public static final int CHANGE_COLOR = 0x123;
    private int currentColor = 0;
    //定义一个颜色数组
    final int[] colors = new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
    };
    final int[] names = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };
    TextView[] views = new TextView[names.length];

//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            //表明消息来自本程序所发送的
//            if (msg.what == CHANGE_COLOR) {
//                for (int i = 0; i < names.length; i++) {
//                    views[i].setBackgroundResource(colors[(i + currentColor) % names.length]);
//                }
//                currentColor++;
//            }
//            super.handleMessage(msg);
//        }
//    };

    private static class MyHandler extends Handler {
        WeakReference<MainActivity> mActivity;

        MyHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            //表明消息来自本程序所发送的
            if (msg.what == CHANGE_COLOR) {
                for (int i = 0; i < activity.names.length; i++) {
                    activity.views[i].setBackgroundResource(
                            activity.colors[(i + activity.currentColor) % activity.names.length]
                    );
                }
                activity.currentColor++;
            }
            super.handleMessage(msg);

        }
    }

    Handler handler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.framelayout_demo);
        for (int i = 0; i < names.length; i++) {
            views[i] = (TextView) findViewById(names[i]);
        }
        //定义一个线程周期性地改变currentColor变量值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(CHANGE_COLOR);
            }
        }, 0, 200);
    }
}
