package com.example.imageviewdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[]{
            R.drawable.t1,
            R.drawable.t2,
            R.drawable.t3,
            R.drawable.t4,
            R.drawable.t5
    };
    int currentImg = 2;//定义默认显示的图片
    private int alpha = 255;//图片初始透明度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button add = (Button) findViewById(R.id.btn_add);
        final Button reduce = (Button) findViewById(R.id.btn_reduce);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final ImageView iv2 = (ImageView) findViewById(R.id.imageDetails);
        final Button next = (Button) findViewById(R.id.btn_nextPhoto);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示下一张图片
                iv.setImageResource(images[++currentImg % images.length]);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == add)
                    alpha += 20;
                if (v == reduce)
                    alpha -= 20;
                if (alpha >= 255)
                    alpha = 255;
                if (alpha <= 0)
                    alpha = 0;
                iv.setImageAlpha(alpha);
            }
        };
        add.setOnClickListener(listener);
        reduce.setOnClickListener(listener);
        iv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) iv.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                //bitmap图片实际大小与iv的缩放比例
                double scale = 1.0 * bitmap.getHeight() / iv.getHeight();
                //获取需要显示的图片的开始点
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);
                if (x + 120 > bitmap.getWidth())
                    x = bitmap.getWidth() - 120;
                if (y + 120 > bitmap.getHeight())
                    y = bitmap.getHeight() - 120;
                //显示图片的指定区域
                iv2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
                iv2.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
