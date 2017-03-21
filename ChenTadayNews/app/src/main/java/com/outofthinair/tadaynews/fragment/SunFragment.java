package com.outofthinair.tadaynews.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.adapter.SunFragmentPagerAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */

public class SunFragment extends Fragment {


    private ViewPager pager;
    private MagicIndicator indicator;

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
        final ArrayList<String> titles =new ArrayList<>();
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
        titles.add("原创");
        titles.add("开眼");
        titles.add("再看一遍");
        titles.add("火山直播");


        //viewPager中的Fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i <titles.size() ; i++) {
            fragments.add(SunItemFragment.getSunItemFragment(titles.get(i)));
        }


        SunFragmentPagerAdapter adapter = new SunFragmentPagerAdapter(getFragmentManager(),fragments,titles);
        pager.setAdapter(adapter);


        //实例化一个导航
        CommonNavigator navigator =new CommonNavigator(getActivity());
        //设置中心点
        navigator.setScrollPivotX(0.65f);
        //用适配器将标题添加到导航者
        navigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                //不同样式实例化的标题布局不同
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setTextSize(25);

                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#00c853"));

                //点击事件
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 6));
                indicator.setLineWidth(UIUtil.dip2px(context, 10));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(Color.parseColor("#00c853"));
                return indicator;
            }
        });

        //和ViewPager关联
        //将导航者设置给指针
        indicator.setNavigator(navigator);
        //ViewPager帮助类
        ViewPagerHelper.bind(indicator,pager);

    }

    //初始化控件
    private void initView(View view){

        indicator = (MagicIndicator) view.findViewById(R.id.sun_lay_indicator);
        pager = (ViewPager) view.findViewById(R.id.sun_lay_pager);
    }
}
