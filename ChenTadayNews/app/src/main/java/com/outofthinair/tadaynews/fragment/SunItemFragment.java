package com.outofthinair.tadaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.outofthinair.tadaynews.R;

/**
 * Created by Administrator on 2017/3/14.
 */

public class SunItemFragment extends Fragment{

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sun_item_frag_layout,null);
        textView = (TextView) view.findViewById(R.id.sun_item_lay_text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        if (name.equals("推荐")){
            textView.setText("推荐");
        }

        if (name.equals("音乐")){
            textView.setText("音乐");
        }

        if (name.equals("搞笑")){
            textView.setText("搞笑");
        }

        if (name.equals("社会")){
            textView.setText("社会");
        }

        if (name.equals("小品")){
            textView.setText("小品");
        }

        if (name.equals("生活")){
            textView.setText("生活");
        }

        if (name.equals("影视")){
            textView.setText("影视");
        }

        if (name.equals("娱乐")){
            textView.setText("娱乐");
        }

        if (name.equals("呆萌")){
            textView.setText("呆萌");
        }

        if (name.equals("游戏")){
            textView.setText("游戏");
        }

        if (name.equals("开眼")){
            textView.setText("开眼");
        }

        if (name.equals("再看一遍")){
            textView.setText("再看一遍");
        }

        if (name.equals("火山直播")){
            textView.setText("火山直播");
        }

        if (name.equals("原创")){
            textView.setText("原创");
        }

    }

    public static SunItemFragment getSunItemFragment(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        SunItemFragment sunItemFragment = new SunItemFragment();
        sunItemFragment.setArguments(bundle);
        return sunItemFragment;
    }
}

