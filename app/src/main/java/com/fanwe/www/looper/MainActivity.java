package com.fanwe.www.looper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fanwe.lib.looper.impl.FSimpleLooper;
import com.fanwe.lib.looper.impl.FSimpleTimeoutLooper;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    private final FSimpleLooper mLooper = new FSimpleLooper();
    private final FSimpleTimeoutLooper mTimeoutLooper = new FSimpleTimeoutLooper();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testSimpleLooper();
        testSimpleTimeoutLooper();
    }

    private void testSimpleLooper()
    {
        // 设置每隔1000毫秒触发一次
        mLooper.setInterval(1000);
        // 设置要循环触发的runnable
        mLooper.setLoopRunnable(new Runnable()
        {
            @Override
            public void run()
            {
                Log.i(TAG, "FSimpleLooper run");
            }
        });
        // 开始循环
        mLooper.start();
    }

    private void testSimpleTimeoutLooper()
    {
        // 设置超时时间，默认10秒
        mTimeoutLooper.setTimeout(5 * 1000);
        // 设置超时需要执行的Runnable
        mTimeoutLooper.setTimeoutRunnable(new Runnable()
        {
            @Override
            public void run()
            {
                Log.e(TAG, "timeout");
            }
        });
        // 设置每隔1000毫秒触发一次
        mTimeoutLooper.setInterval(1000);
        // 设置要循环触发的runnable
        mTimeoutLooper.setLoopRunnable(new Runnable()
        {
            @Override
            public void run()
            {
                Log.e(TAG, "FSimpleTimeoutLooper run");
            }
        });
        // 开始循环
        mTimeoutLooper.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mLooper.stop(); // 停止循环
        mTimeoutLooper.stop(); // 停止循环
    }
}
