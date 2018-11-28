package com.ryg.chapter_12;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        new Thread(new Runnable() {
            @Override
            public void run() {
                testANR();
            }
        }).start();
        SystemClock.sleep(10);
        initView();
    }

    private synchronized void initView() {

    }

    private synchronized void testANR() {
        SystemClock.sleep(30*1000);
    }
}
