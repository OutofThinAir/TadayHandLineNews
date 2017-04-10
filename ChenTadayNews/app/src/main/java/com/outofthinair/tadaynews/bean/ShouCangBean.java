package com.outofthinair.tadaynews.bean;

/**
 * Created by Administrator on 2017/3/23.
 */

public class ShouCangBean {
    private int _id;
    private String title;
    private String info;
    private String picUrl;

    private String particularsUrl;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }



    public String getParticularsUrl() {
        return particularsUrl;
    }

    public void setParticularsUrl(String particularsUrl) {
        this.particularsUrl = particularsUrl;
    }

    @Override
    public String toString() {
        return "ShouCangBean{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", particularsUrl='" + particularsUrl + '\'' +
                '}';
    }
}
