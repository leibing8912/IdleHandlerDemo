package com.yy.mobile.idlehandlerdemo;

import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @className: IdleHandlerActivity
 * @classDescription: IdleHandler用法测试
 * @author: leibing
 * @email: leibing@yy.com
 * @createTime:2018/9/15
 */
public class IdleHandlerActivity extends AppCompatActivity {
    // TAG
    private final static String TAG = "IdleHandlerActivity";
    // 刷新按钮
    private Button requestLayoutBtn;
    // 刷新view
    private IdleHandlerView requestLayoutIhv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"#onCreate");
        setContentView(R.layout.activity_main);
        // findView
        requestLayoutBtn = findViewById(R.id.btn_request_layout);
        requestLayoutIhv = findViewById(R.id.ihv_request_layout);
        // click listener
        requestLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIdleHandler();
                Log.v(TAG,"#requestLayoutIhv requestLayout");
                requestLayoutIhv.requestLayout();
            }
        });
        // add idle handle
        addIdleHandler();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"#onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"#onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"#onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"#onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"#onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"#onDestroy");
    }

    /**
     * IdleHandler就是在looper里面的message暂时处理完了，这个时候会回调这个接口，返回false，
     * 那么就会移除它，返回true就会在下次message处理完了的时候继续回调
     */
    private void addIdleHandler(){
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.v(TAG, "#looper message has worked out");
                return false;
            }
        });
    }
}
