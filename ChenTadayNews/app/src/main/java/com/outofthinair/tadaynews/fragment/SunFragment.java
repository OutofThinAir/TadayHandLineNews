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
import com.outofthinair.tadaynews.adapter.SunFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */

public class SunFragment extends Fragment {

    private TabLayout tab;
    private ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sun_frag_layout,null);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //标题选项卡
        ArrayList<String> titles =new ArrayList<>();
        titles.add("推荐");
        titles.add("音乐");
        titles.add("搞笑");
        titles.add("社会");
        titles.add("小品");
        titles.add("生活");
        titles.add("影视");
        titles.add("娱乐");
        titles.add("呆萌");
        titles.add("游戏");
        titles.add("开眼");
        titles.add("再看一遍");
        titles.add("火山直播");
        titles.add("原创");

        //viewPager中的Fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i <titles.size() ; i++) {
            fragments.add(SunItemFragment.getSunItemFragment(titles.get(i)));
        }

        SunFragmentPagerAdapter adapter = new SunFragmentPagerAdapter(getFragmentManager(),fragments,titles);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
        tab.setTabsFromPagerAdapter(adapter);


    }

    //初始化控件
    private void initView(View view){
        tab = (TabLayout) view.findViewById(R.id.sun_lay_tab);
        pager = (ViewPager) view.findViewById(R.id.sun_lay_pager);
    }
}
