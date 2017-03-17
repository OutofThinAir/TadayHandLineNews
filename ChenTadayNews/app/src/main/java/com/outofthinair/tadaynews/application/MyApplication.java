package com.outofthinair.tadaynews.application;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MyApplication extends Application {
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Xutil3
        x.Ext.init(this);
        //不开启debug模式
        x.Ext.setDebug(false);

        //qq登录初始化
        UMShareAPI.get(this);
    }
}
