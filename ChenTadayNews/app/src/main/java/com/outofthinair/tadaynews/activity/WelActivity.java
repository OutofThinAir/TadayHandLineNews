package com.outofthinair.tadaynews.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.outofthinair.tadaynews.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/3/10.
 */

public class WelActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wel_layout);
        //倒计时跳转
        Timer timer = new Timer();
        //timer的任务栈
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(WelActivity.this,MainActivity.class));
                finish();
            }
        };

        timer.schedule(task,2000);
    }
}
