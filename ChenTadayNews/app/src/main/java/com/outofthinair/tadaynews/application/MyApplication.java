package com.outofthinair.tadaynews.application;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MyApplication extends Application {
    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

    }
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Xutil3
        x.Ext.init(this);
        //不开启debug模式
        x.Ext.setDebug(false);
        SMSSDK.initSDK(this, "1c108d6b1e575", "b09e557f971a157a7a050fa2961b3fe3");
        //qq登录初始化
        UMShareAPI.get(this);
    }
}
