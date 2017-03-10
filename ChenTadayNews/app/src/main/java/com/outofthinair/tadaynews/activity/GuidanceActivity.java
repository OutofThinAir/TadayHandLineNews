package com.outofthinair.tadaynews.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.outofthinair.tadaynews.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */

public class GuidanceActivity extends Activity {

    private ArrayList<ImageView> imageViews;
    private ViewPager guidancePager;
    private ImageButton guidanceInto;
    private SharedPreferences pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidance_layout);

        //初始化控件
        initView();

        //数据存储
        pre = getSharedPreferences("cofig",MODE_PRIVATE);
        boolean flag = pre.getBoolean("flag", false);
        if (flag){
            startActivity(new Intent(GuidanceActivity.this,WelActivity.class));
            finish();
        }

        //引导页的图片
        imageViews = new ArrayList<>();
        final int [] pics = new int[]{
                R.mipmap.guidance_one,R.mipmap.guidance_two,R.mipmap.guidance_three
        };

        for (int i = 0; i <pics.length ; i++) {
            ImageView iv = new ImageView(GuidanceActivity.this);
            iv.setImageResource(pics[i]);
            imageViews.add(iv);
        }

        //设置适配器
        MyAdapter adapter =new MyAdapter();
        guidancePager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //ViewPager监听
        guidancePager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position==imageViews.size()-1){
                    guidanceInto.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //监听跳转
        guidanceInto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuidanceActivity.this,WelActivity.class));
                SharedPreferences.Editor edit = pre.edit();
                edit.putBoolean("flag",true);
                edit.commit();
                finish();

            }
        });

    }
    //初始化控件
    private void initView(){
        guidancePager = (ViewPager) findViewById(R.id.guidance_lay_vp);
        guidanceInto = (ImageButton) findViewById(R.id.guidance_lay_into);

    }
    //ViewPager的适配器
    private class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));

        }
    }
}
