package com.outofthinair.tadaynews.util;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ShanChuanPic {
    //上传网址
    static String url = "http://169.254.217.5:8080/TadayNewsServer/FileServlet";
    public static void shanchuanPic(String path){
        RequestParams params = new RequestParams(url);
        params.setMultipart(true);
        params.addBodyParameter("file",new File(path));

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }
}
