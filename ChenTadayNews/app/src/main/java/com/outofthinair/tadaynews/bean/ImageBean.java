package com.outofthinair.tadaynews.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
/*
 "height": 360,
            "uri": "list/184f0006b0b145835ec7",
            "url": "http://p2.pstatp.com/list/300x196/184f0006b0b145835ec7.webp",
            "url_list":
 */
public class ImageBean {
    private String height;
    private String uri;
    private String url;
    private List<URLBean> url_list;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<URLBean> getUrl_list() {
        return url_list;
    }

    public void setUrl_list(List<URLBean> url_list) {
        this.url_list = url_list;
    }
}
