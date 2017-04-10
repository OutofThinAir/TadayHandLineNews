package com.outofthinair.tadaynews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.bean.ShouCangBean;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/23.
 */

public class ShouCangListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ShouCangBean> list;

    public ShouCangListAdapter(Context context, ArrayList<ShouCangBean> list) {
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
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.shouc_list_item_layout,null);
            holder=new ViewHolder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.shou_list_item_iamge);
            holder.title= (TextView) convertView.findViewById(R.id.shou_list_item_title);
            holder.info= (TextView) convertView.findViewById(R.id.shou_list_item_info);
            convertView.setTag(holder);

        }else {
           holder= (ViewHolder) convertView.getTag();
        }
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(context,R.anim.alph_anim);
        holder.title.setText(list.get(position).getTitle());
        holder.info.setText(list.get(position).getInfo());
        ImageOptions options = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.app_ic)
                .setFailureDrawableId(R.mipmap.app_ic)
                .setAnimation(animationSet)
                .build();
        x.image().bind(holder.imageView,list.get(position).getPicUrl(),options);
        return convertView;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView info;
    }
}
