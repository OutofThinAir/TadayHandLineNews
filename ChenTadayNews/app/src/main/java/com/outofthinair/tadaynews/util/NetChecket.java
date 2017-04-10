package com.outofthinair.tadaynews.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2017/3/27.
 */

public class NetChecket {
    public static boolean isHaveNet(Context context){

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }

        return false;
    }

    public static boolean isWifi(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null&&info.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        }

        return false;
    }
}
