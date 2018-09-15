package com.yy.mobile.idlehandlerdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @className: IdleHandlerView
 * @classDescription: 测试view耗时
 * @author: leibing
 * @email: leibing@yy.com
 * @createTime:2018/9/15
 */

public class IdleHandlerView extends View{
    // TAG
    private final static String TAG = "IdleHandlerView";

    public IdleHandlerView(Context context) {
        super(context);
    }

    public IdleHandlerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IdleHandlerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.v(TAG, "#onMeasure start");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "#onMeasure end");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.v(TAG, "#onLayout start");
        super.onLayout(changed, left, top, right, bottom);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "#onLayout end");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.v(TAG, "#onDraw start");
        super.onDraw(canvas);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "#onDraw end");
    }
}
