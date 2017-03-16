package com.outofthinair.tadaynews.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Xutil3
        x.Ext.init(this);
        //不开启debug模式
        x.Ext.setDebug(false);
    }
}
