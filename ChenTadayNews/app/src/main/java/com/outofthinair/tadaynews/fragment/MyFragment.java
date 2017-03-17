package com.outofthinair.tadaynews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.activity.MainActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by Administrator on 2017/3/10.
 */

public class MyFragment extends Fragment implements View.OnClickListener{



    private ImageButton shoujiLog;
    private LinearLayout linearLayout;
    private TextView genLog;
    private ImageView touxiang;
    private TextView uname;
    private LinearLayout guanzhud;
    private ImageButton qqLog;
    UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getActivity(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), data.get("name"), Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "iconurl", Toast.LENGTH_SHORT).show();
            //隐藏登录布局
            genLog.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);

            //显示用户信息布局
            touxiang.setVisibility(View.VISIBLE);
            uname.setVisibility(View.VISIBLE);
            guanzhud.setVisibility(View.VISIBLE);
            uname.setText(data.get("name"));
            ImageOptions options = new ImageOptions.Builder()
                    .setCircular(true)
                    .build();
            x.image().bind(touxiang,data.get("iconurl"),options);


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getActivity(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getActivity(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.my_frag_layout,null);
        //初始化控件
        initView(view);
        //监听事件

        shoujiLog.setOnClickListener(this);
        qqLog.setOnClickListener(this);


        return view;
    }

    private void initView(View view){
        //登录之后显示的界面
        touxiang = (ImageView) view.findViewById(R.id.my_frag_lay_touxiang);
        uname = (TextView) view.findViewById(R.id.my_frag_lay_uname);
        ImageView tiao_uxinxi= (ImageView) view.findViewById(R.id.my_frag_lay_next);
        guanzhud = (LinearLayout) view.findViewById(R.id.my_frag_lay_loghou);
        TextView dongtai= (TextView) view.findViewById(R.id.my_frag_lay_dongtai);
        TextView guanzhu= (TextView) view.findViewById(R.id.my_frag_lay_guanzhu);
        TextView fensi= (TextView) view.findViewById(R.id.my_frag_lay_fensi);
        TextView fangke= (TextView) view.findViewById(R.id.my_frag_lay_fangke);


        //一些登录按钮
        qqLog = (ImageButton) view.findViewById(R.id.my_frag_lay_qqlog);
        shoujiLog = (ImageButton) view.findViewById(R.id.my_frag_lay_shoujilog);
        genLog = (TextView) view.findViewById(R.id.my_frag_lay_gengduolog);
        linearLayout = (LinearLayout) view.findViewById(R.id.my_frag_lay_logq);
        //都有的界面
        TextView shoucang = (TextView) view.findViewById(R.id.my_frag_lay_shoucang);
        TextView lishi = (TextView) view.findViewById(R.id.my_frag_lay_lishi);


        RelativeLayout xiaoxi = (RelativeLayout) view.findViewById(R.id.my_frag_lay_xiaoxitongzhi);
        RelativeLayout shangcheng = (RelativeLayout) view.findViewById(R.id.my_frag_lay_shangcheng);
        RelativeLayout tegong = (RelativeLayout) view.findViewById(R.id.my_frag_lay_tegong);
        RelativeLayout baolaio = (RelativeLayout) view.findViewById(R.id.my_frag_lay_boliao);
        RelativeLayout fankui = (RelativeLayout) view.findViewById(R.id.my_frag_lay_fankui);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //回调获得用户名密码
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);

    }

    
    @Override
    public void onClick(View v) {


        switch (v.getId()){


            case R.id.my_frag_lay_shoujilog:
                //打开注册页面
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        //隐藏登录布局
                    genLog.setVisibility(View.GONE);
                        linearLayout.setVisibility(View.GONE);

                        //显示用户信息布局
                        touxiang.setVisibility(View.VISIBLE);
                        uname.setVisibility(View.VISIBLE);
                        guanzhud.setVisibility(View.VISIBLE);
                     // 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
                         uname.setText("用户"+phone);

                        }
                    }
                });
                registerPage.show(getActivity());

                break;

            case R.id.my_frag_lay_qqlog:
                UMShareAPI  mShareAPI = UMShareAPI.get( getActivity() );
                mShareAPI.doOauthVerify(getActivity(), SHARE_MEDIA.QQ, umAuthListener);
                break;
        }

    }


}
