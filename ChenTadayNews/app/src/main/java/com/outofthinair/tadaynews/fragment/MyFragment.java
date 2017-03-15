package com.outofthinair.tadaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.outofthinair.tadaynews.R;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.my_frag_layout,null);
        //初始化控件
        initView(view);


        return view;
    }

    private void initView(View view){
        //登录之后显示的界面
        ImageView touxiang = (ImageView) view.findViewById(R.id.my_frag_lay_touxiang);
        TextView uname = (TextView) view.findViewById(R.id.my_frag_lay_uname);
        ImageView tiao_uxinxi= (ImageView) view.findViewById(R.id.my_frag_lay_next);
        LinearLayout guanzhud = (LinearLayout) view.findViewById(R.id.my_frag_lay_loghou);
        TextView dongtai= (TextView) view.findViewById(R.id.my_frag_lay_dongtai);
        TextView guanzhu= (TextView) view.findViewById(R.id.my_frag_lay_guanzhu);
        TextView fensi= (TextView) view.findViewById(R.id.my_frag_lay_fensi);
        TextView fangke= (TextView) view.findViewById(R.id.my_frag_lay_fangke);

        //一些登录按钮
        ImageButton qqLog = (ImageButton) view.findViewById(R.id.my_frag_lay_qqlog);
        ImageButton shoujiLog = (ImageButton) view.findViewById(R.id.my_frag_lay_shoujilog);
        TextView genLog = (TextView) view.findViewById(R.id.my_frag_lay_gengduolog);
        //都有的界面
        TextView shoucang = (TextView) view.findViewById(R.id.my_frag_lay_shoucang);
        TextView lishi = (TextView) view.findViewById(R.id.my_frag_lay_lishi);
        TextView yejian = (TextView) view.findViewById(R.id.my_frag_lay_yejian);

        RelativeLayout xiaoxi = (RelativeLayout) view.findViewById(R.id.my_frag_lay_xiaoxitongzhi);
        RelativeLayout shangcheng = (RelativeLayout) view.findViewById(R.id.my_frag_lay_shangcheng);
        RelativeLayout tegong = (RelativeLayout) view.findViewById(R.id.my_frag_lay_tegong);
        RelativeLayout baolaio = (RelativeLayout) view.findViewById(R.id.my_frag_lay_boliao);
        RelativeLayout fankui = (RelativeLayout) view.findViewById(R.id.my_frag_lay_fankui);
        RelativeLayout xitong = (RelativeLayout) view.findViewById(R.id.my_frag_lay_xitong);



    }
}
