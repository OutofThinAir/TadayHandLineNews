package com.outofthinair.tadaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.adapter.HomeFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */

public class HomeFragment extends Fragment {


    private ViewPager pager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view  =inflater.inflate(R.layout.home_frag_layout,null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //给页卡添加标题
        ArrayList<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热点");
        titles.add("视频");
        titles.add("社会");
        titles.add("娱乐");
        titles.add("图片");
        titles.add("科技");
        titles.add("汽车");
        titles.add("体育");
        titles.add("财经");
        titles.add("军事");
        titles.add("国际");
        titles.add("段子");
        titles.add("趣图");
        titles.add("美女");
        titles.add("健康");
        titles.add("正能量");
        titles.add("特卖");
        titles.add("房产");

        //页卡的视图
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i <titles.size() ; i++) {
            fragments.add(HomeItemFragment.getNewFragment(titles.get(i)));
        }




        //设置模式,为系统默认模式
        //在布局中设置模式为可滚动

        //ViewPager设置S适配器
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getFragmentManager(),fragments,titles);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(adapter);


    }

    //初始化控件
    private void initView(View view){
        tabLayout = (TabLayout) view.findViewById(R.id.home_lay_table);
        pager = (ViewPager) view.findViewById(R.id.home_lay_pager);
    }
}
