package com.example.ball;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawCircleView extends View {
    public float currentX = 40;
    public float currentY = 50;
    Paint p = new Paint();//定义画笔

    public DrawCircleView(Context context) {
        super(context);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX, currentY, 15, p);
    }

    //重写触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        invalidate();//通知重绘当前组件
        return true;//true表示方法已经处理该事件
    }
}
