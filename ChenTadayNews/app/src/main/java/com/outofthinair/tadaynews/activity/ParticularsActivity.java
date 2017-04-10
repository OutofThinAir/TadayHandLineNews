package com.outofthinair.tadaynews.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.outofthinair.tadaynews.R;

/**
 * Created by Administrator on 2017/3/22.
 */

public class ParticularsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.particulars_ac_layout);
        //初始化控件
        WebView webView = (WebView) findViewById(R.id.particulars_webview);
        Intent intent =getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);
        //支持缩放
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLoadsImagesAutomatically(true);  //支持自动加载图片

        //设置不调用浏览器,在本页显示
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);//启用js
        webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
        //关闭缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


    }
}
