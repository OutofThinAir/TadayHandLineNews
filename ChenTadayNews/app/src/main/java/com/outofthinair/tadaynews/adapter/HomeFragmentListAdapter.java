package com.outofthinair.tadaynews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.bean.GunggaoBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2017/3/16.
 */

public class HomeFragmentListAdapter extends BaseAdapter {
    //定义三种布局的TYPE
    private final int TYPE_0=0;
    private final int TYPE_1=1;
    private final int TYPE_2=2;
    //数据
    private Context context;
    private ArrayList<JSONObject> list;
    private ImageOptions options;

    public HomeFragmentListAdapter(Context context, ArrayList<JSONObject> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type=getItemViewType(position);
        //3个ViewHolder
        ViewHolder0 v0=null;
        ViewHolder1 v1=null;
        ViewHolder2 v2=null;
        if (convertView==null){
            //初始化布局
            switch (type){
                case TYPE_0:
                    convertView=View.inflate(context,R.layout.homeitem_frag_list_item_01,null);
                    v0=new ViewHolder0();
                    v0.textView0= (TextView) convertView.findViewById(R.id.homeitem_frag_item_01_text);
                    v0.imageView0 = (ImageView) convertView.findViewById(R.id.homeitem_frag_item_01_image);
                    convertView.setTag(v0);

                    break;
                case TYPE_1:
                    convertView=View.inflate(context,R.layout.homeitem_frag_list_item_02,null);
                    v1=new ViewHolder1();
                    v1.textView1= (TextView) convertView.findViewById(R.id.homeitem_frag_list_item02_text);
                    v1.imageView20= (ImageView) convertView.findViewById(R.id.homeitem_frag_list_item02_image01);
                    v1.imageView21= (ImageView) convertView.findViewById(R.id.homeitem_frag_list_item02_image02);
                    v1.imageView22= (ImageView) convertView.findViewById(R.id.homeitem_frag_list_item02_image03);
                    convertView.setTag(v1);
                    break;
                case TYPE_2:
                    convertView=View.inflate(context,R.layout.homeitem_frag_list_item_03,null);
                    v2=new ViewHolder2();
                    v2.textView2= (TextView) convertView.findViewById(R.id.homeitem_frag_item_03_text);
                    v2.imageView02= (ImageView) convertView.findViewById(R.id.homeitem_frag_item_03_image);
                    convertView.setTag(v2);
                    break;

            }
        }else {

            //打标签
            switch (type){
                case TYPE_0:
                    v0= (ViewHolder0) convertView.getTag();
                    break;
                case TYPE_1:
                    v1= (ViewHolder1) convertView.getTag();
                    break;
                case TYPE_2:
                    v2= (ViewHolder2) convertView.getTag();
                    break;

            }


        }
        //图片加载
        //加载中默认显示图片
//加载失败后默认显示图片
        options = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.app_ic)//加载中默认显示图片
                .setFailureDrawableId(R.mipmap.app_ic)//加载失败后默认显示图片
                .setImageScaleType(ImageView.ScaleType.FIT_XY)

                .build();
        //设置数据
        switch (type){
            case TYPE_0:
                try {
                    v0.textView0.setText(list.get(position).getString("title"));
                    //Log.d("url------->",list.get(position));
                    JSONObject middle_image = list.get(position).getJSONObject("middle_image");
                    x.image().bind(v0.imageView0,middle_image.getString("url"),options);
                } catch (Exception e) {
                    e.printStackTrace();
                }



                break;
            case TYPE_1:
                try {
                    v1.textView1.setText(list.get(position).getString("title"));
                    JSONArray image_list = list.get(position).getJSONArray("image_list");


                    JSONObject jsonObject = image_list.getJSONObject(0);
                    x.image().bind(v1.imageView20,jsonObject.getString("url"),options);
                    JSONObject jsonObject1 = image_list.getJSONObject(1);
                    x.image().bind(v1.imageView21,jsonObject1.getString("url"),options);
                    JSONObject jsonObject2 = image_list.getJSONObject(2);
                    x.image().bind(v1.imageView22,jsonObject2.getString("url"),options);


                } catch (Exception e) {
                    e.printStackTrace();
                }



                break;
            case TYPE_2:
                try {
                    v2.textView2.setText(list.get(position).getString("title"));
                    JSONObject video_info = list.get(position).getJSONObject("video_detail_info");
                    JSONObject detail_image = video_info.getJSONObject("detail_video_large_image");
                    x.image().bind(v2.imageView02,detail_image.getString("url"),options);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
       JSONObject obj = list.get(position);
        try {
            if (obj.getBoolean("has_image")==false&&obj.getBoolean("has_video")==false){
                return TYPE_0;
            }else if (obj.getBoolean("has_image")==true){
                return TYPE_1;
            }else if (obj.getBoolean("has_video")==true){
                return TYPE_2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    //ViewHolder优化
    private class ViewHolder0{
        TextView textView0;
        ImageView imageView0;

    }

    private class ViewHolder1{
        TextView textView1;
        ImageView imageView20;
        ImageView imageView21;
        ImageView imageView22;
    }

    private  class ViewHolder2{
        TextView textView2;
        ImageView imageView02;
    }
}
