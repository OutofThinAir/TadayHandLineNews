package com.outofthinair.tadaynews.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.bean.UserBean;
import com.outofthinair.tadaynews.fragment.GuanZhuFragment;
import com.outofthinair.tadaynews.fragment.HomeFragment;
import com.outofthinair.tadaynews.fragment.MyFragment;
import com.outofthinair.tadaynews.fragment.SunFragment;
import com.igexin.sdk.PushManager;
import com.outofthinair.tadaynews.sqlite.MySqLite;
import com.outofthinair.tadaynews.util.NetChecket;
import com.outofthinair.tadaynews.util.SqlUtil;
import com.umeng.socialize.UMShareAPI;

import org.json.JSONException;

import cn.smssdk.SMSSDK;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private FragmentManager manager;
    private RadioGroup group;
    private RadioButton home;
    private RadioButton sun;
    private RadioButton guanzhu;
    private RadioButton mys;
    private HomeFragment homeFragment;
    private SunFragment sunFragment;
    private GuanZhuFragment guanZhuFragment;
    private MyFragment myFragment;
    private SlidingMenu menu;
    private TextView ryqh;
    private OnTuichu ontuichu;

    // 默认是日间模式
    private int theme = R.style.AppTheme;
    private Button tuichu;
    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 判断是否有主题存储
        if(savedInstanceState != null){
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        //添加Fragment
        manager = getSupportFragmentManager();


        setContentView(R.layout.activity_main);
       // SMSSDK.initSDK(this, "1c108d6b1e575", "b09e557f971a157a7a050fa2961b3fe3");

        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(),com.outofthinair.tadaynews.service.MyService.class);

        //侧滑效果的实现
        menu = new SlidingMenu(MainActivity.this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setBehindOffset(200);
        menu.setMenu(R.layout.cehua_layout);
        menu.attachToActivity(MainActivity.this,SlidingMenu.SLIDING_CONTENT);
        //初始化控件
        initView();
        MySqLite sqLite = new MySqLite(MainActivity.this);
        database = sqLite.getWritableDatabase();

        homeFragment = new HomeFragment();
        sunFragment = new SunFragment();
        guanZhuFragment = new GuanZhuFragment();
        myFragment = new MyFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_lay_frame, homeFragment,"hf");
        transaction.add(R.id.main_lay_frame, sunFragment,"sf");
        transaction.add(R.id.main_lay_frame, guanZhuFragment,"gf");
        transaction.add(R.id.main_lay_frame, myFragment,"mf");
        transaction.hide(sunFragment);
        transaction.hide(guanZhuFragment);
        transaction.hide(myFragment);

        transaction.commit();
        //设置监听事件
        home.setOnClickListener(this);
        sun.setOnClickListener(this);
        guanzhu.setOnClickListener(this);
        mys.setOnClickListener(this);
        tuichu.setOnClickListener(this);
        //侧滑页监听
        ryqh.setOnClickListener(this);

        //默认选择第一个导航
        home.setSelected(true);
        home.setChecked(true);





    }


    //初始化控件
    private void initView(){
        group = (RadioGroup) findViewById(R.id.main_lay_rg);
        home = (RadioButton) findViewById(R.id.main_lay_down_shouye);
        sun = (RadioButton) findViewById(R.id.main_lay_down_yang);
        guanzhu = (RadioButton) findViewById(R.id.main_lay_down_guanzhu);
        mys = (RadioButton) findViewById(R.id.main_lay_down_wode);
        //侧滑界面的控件
        ryqh = (TextView) menu.findViewById(R.id.cehua_lay_ryqh);
        TextView shenliang = (TextView) menu.findViewById(R.id.cehua_lay_shenliuliang);
        TextView qingchu = (TextView) menu.findViewById(R.id.cehua_lay_qingchu);
        TextView lixian = (TextView) menu.findViewById(R.id.cehua_lay_lixian);
        TextView jiancha = (TextView) menu.findViewById(R.id.cehua_lay_gengxian);
        tuichu = (Button) menu.findViewById(R.id.chehua_lay_tuchi);

    }

    //Fragment之间的切换
    public void cutFragment(Fragment newFrag,Fragment oldFrag01,Fragment oldFrag02,Fragment oldFrag03){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(newFrag);
        transaction.hide(oldFrag01);
        transaction.hide(oldFrag02);
        transaction.hide(oldFrag03);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_lay_down_shouye:
                cutFragment(homeFragment,sunFragment,guanZhuFragment,myFragment);
                home.setSelected(true);
                sun.setSelected(false);
                guanzhu.setSelected(false);
                mys.setSelected(false);
                break;
            case R.id.main_lay_down_yang:
                boolean wifi = NetChecket.isWifi(MainActivity.this);

                //判断是否是Wifi
                if(wifi){
                    cutFragment(sunFragment,homeFragment,guanZhuFragment,myFragment);
                }else{
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("当前是移动数据,是否查看详情");
                    builder.setPositiveButton("土豪继续查看!!!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            cutFragment(sunFragment,homeFragment,guanZhuFragment,myFragment);
                            builder.create().dismiss();
                        }
                    });

                    builder.setNegativeButton("设置Wifi网络", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //跳转到WIFI设置
                            Intent intent = null;
                            intent=new Intent("android.settings.WIFI_SETTINGS");
                            startActivity(intent);
                            builder.create().dismiss();
                        }

                    });

                    builder.create().show();
                }

                home.setSelected(false);
                sun.setSelected(true);
                guanzhu.setSelected(false);
                mys.setSelected(false);
                break;
            case R.id.main_lay_down_guanzhu:
                cutFragment(guanZhuFragment,sunFragment,homeFragment,myFragment);
                home.setSelected(false);
                sun.setSelected(false);
                guanzhu.setSelected(true);
                mys.setSelected(false);
                break;
            case R.id.main_lay_down_wode:
                cutFragment(myFragment,sunFragment,guanZhuFragment,homeFragment);
                home.setSelected(false);
                sun.setSelected(false);
                guanzhu.setSelected(false);
                mys.setSelected(true);
                break;
            case R.id.cehua_lay_ryqh:

                theme = (theme == R.style.AppTheme) ? R.style.NightAppTheme : R.style.AppTheme;
                MainActivity.this.recreate();
                break;
            case R.id.chehua_lay_tuchi:
                ontuichu.tuichu(false);
                UserBean userBean = new UserBean();
                SqlUtil.queryByLoginToUser(database,"1",userBean);
                SqlUtil.updateLogin(database,userBean.getUname(),"0");

                break;

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");

    }


    //接口回调
    public interface OnTuichu{
        void tuichu(boolean flag);
    }

    public  void setOnTuichu(OnTuichu ontuichu){
        this.ontuichu= ontuichu;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //回调获得用户名密码
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}


