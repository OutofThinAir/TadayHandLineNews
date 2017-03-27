package com.outofthinair.tadaynews.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
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
import com.outofthinair.tadaynews.bean.UserBean;
import com.outofthinair.tadaynews.sqlite.MySqLite;
import com.outofthinair.tadaynews.util.ShanChuanPic;
import com.outofthinair.tadaynews.util.SqlUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
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

    public ArrayList<SnsPlatform> platforms = new ArrayList<SnsPlatform>();
    private SHARE_MEDIA[] list = {SHARE_MEDIA.QQ};
    private SQLiteDatabase database;
    private ImageView tiao_uxinxi;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.my_frag_layout,null);
        //初始化控件
        initView(view);
        //监听事件

        shoujiLog.setOnClickListener(this);
        qqLog.setOnClickListener(this);
        tiao_uxinxi.setOnClickListener(this);
        touxiang.setOnClickListener(this);
        MySqLite sqLite = new MySqLite(getActivity());
        database = sqLite.getWritableDatabase();

        //查询数据设置头像(日夜间模式切换时重置设置头像)
        UserBean userBean = new UserBean();
        SqlUtil.queryByLoginToUser(database,"1",userBean);
        if (userBean.getUname()!=null){

            ImageOptions options = new ImageOptions.Builder()
                    .setLoadingDrawableId(R.mipmap.app_ic)
                    .setFailureDrawableId(R.mipmap.app_ic)
                    .setCircular(true)
                    .build();

            x.image().bind(touxiang,userBean.getHeadPic(),options);
        }
        return view;
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initPlatforms();

        UserBean userBean = new UserBean();
        SqlUtil.queryByLoginToUser(database,"1",userBean);
        if (userBean.getUname()!=null){
            ImageOptions options = new ImageOptions.Builder()
                    .setLoadingDrawableId(R.mipmap.app_ic)
                    .setFailureDrawableId(R.mipmap.app_ic)
                    .setCircular(true)
                    .build();

            x.image().bind(touxiang,userBean.getHeadPic(),options);
        }


    }


    private void initView(View view){
        //登录之后显示的界面
        touxiang = (ImageView) view.findViewById(R.id.my_frag_lay_touxiang);
        uname = (TextView) view.findViewById(R.id.my_frag_lay_uname);
        tiao_uxinxi = (ImageView) view.findViewById(R.id.my_frag_lay_next);
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
                         uname.setText("用户:"+phone);
                            //添加数据
                            SqlUtil.insertUser(database,"用户"+phone,null,"1");

                            //查询数据设置头像
                            UserBean userBean = new UserBean();
                            SqlUtil.queryByLoginToUser(database,"1",userBean);
                            if (userBean.getUname()!=null){

                                ImageOptions options = new ImageOptions.Builder()
                                        .setLoadingDrawableId(R.mipmap.app_ic)
                                        .setFailureDrawableId(R.mipmap.app_ic)
                                        .setCircular(true)
                                        .build();

                                x.image().bind(touxiang,userBean.getHeadPic(),options);
                            }


                        }
                    }
                });
                registerPage.show(getActivity());

                break;

            case R.id.my_frag_lay_qqlog:
                UMShareAPI  mShareAPI = UMShareAPI.get( getActivity() );
                mShareAPI.doOauthVerify(getActivity(), platforms.get(0).mPlatform, umAuthListener);
                mShareAPI.getPlatformInfo(getActivity(), platforms.get(0).mPlatform, umAuthListener);


                break;
            case R.id.my_frag_lay_touxiang:

                //上传头像,调用系统相册
                //调用相册
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 200);

                break;

        }

    }

    UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Toast.makeText(getActivity(), "授权", Toast.LENGTH_SHORT).show();
            Log.d("safsadf","onStart");

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> data) {
            Log.d("safsadf","onComplete");
            Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
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
            SqlUtil.insertUser(database,data.get("name"),data.get("iconurl"),"1");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.d("safsadf","onError");
            Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Log.d("safsadf","onCancel");
            Toast.makeText(getActivity(), "终止", Toast.LENGTH_SHORT).show();
        }
    };


    private void initPlatforms() {
        platforms.clear();
        for (SHARE_MEDIA e : list) {
            if (!e.toString().equals(SHARE_MEDIA.GENERIC.toString())) {
                platforms.add(e.toSnsPlatform());
            }
        }


}

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            UserBean userBean = new UserBean();
            SqlUtil.queryByLoginToUser(database,"1",userBean);
            //判断是否登录
            if (userBean.getUname()!=null){
                //隐藏登录布局
                genLog.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);

                //显示用户信息布局
                touxiang.setVisibility(View.VISIBLE);
                uname.setVisibility(View.VISIBLE);
                guanzhud.setVisibility(View.VISIBLE);
                uname.setText(userBean.getUname());
                ImageOptions options = new ImageOptions.Builder()
                        .setLoadingDrawableId(R.mipmap.app_ic)
                        .setFailureDrawableId(R.mipmap.app_ic)
                        .setCircular(true)
                        .build();

                x.image().bind(touxiang,userBean.getHeadPic(),options);
            }else{
                //隐藏登录布局
                genLog.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);

                //显示用户信息布局
                touxiang.setVisibility(View.GONE);
                uname.setVisibility(View.GONE);
                guanzhud.setVisibility(View.GONE);
            }
        }else{

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //回调获得用户名密码
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);

        //获得相册的回传值,---图片路径
        //获取图片路径
        if (requestCode == 200 && resultCode == getActivity().RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getActivity().getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            //图片路径
            String imagePath = c.getString(columnIndex);

            //将图片上传到服务器
            ShanChuanPic.shanchuanPic(imagePath);
            //更改数据库
            SqlUtil.updateHeadUrl(database,uname.getText().toString(),imagePath);
            //x.image().bind(touxiang,imagePath);
            //Bitmap bm = BitmapFactory.decodeFile(imagePath);


                ImageOptions options = new ImageOptions.Builder()
                        .setLoadingDrawableId(R.mipmap.app_ic)
                        .setFailureDrawableId(R.mipmap.app_ic)
                        .setCircular(true)
                        .build();

                x.image().bind(touxiang,imagePath,options);



            //touxiang.setImageBitmap(bm);
            c.close();
        }

    }

}
