package com.outofthinair.tadaynews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.bean.ShiPinBean;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ShiPinAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ShiPinBean> list;

    public ShiPinAdapter(Context context, ArrayList<ShiPinBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh ;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.sun_list_item_lay,null);
            vh=new ViewHolder();
            vh.jc= (JCVideoPlayerStandard) convertView.findViewById(R.id.sun_item_lay_jc);
            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        boolean b = vh.jc.setUp(list.get(position).getMp4_url(), list.get(position).getTitle());
        if (b){
            Glide.with(context).load(list.get(position).getCover()).into(vh.jc.thumbImageView);

        }
        //vh.jc.thumbImageView.;
        return convertView;
    }
    private class ViewHolder{
        JCVideoPlayerStandard jc ;
    }
}
