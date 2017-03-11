package com.outofthinair.tadaynews.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.fragment.GuanZhuFragment;
import com.outofthinair.tadaynews.fragment.HomeFragment;
import com.outofthinair.tadaynews.fragment.MyFragment;
import com.outofthinair.tadaynews.fragment.SunFragment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();

        //侧滑效果的实现
        SlidingMenu menu = new SlidingMenu(MainActivity.this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setBehindOffset(200);
        menu.setMenu(R.layout.cehua_layout);
        menu.attachToActivity(MainActivity.this,SlidingMenu.SLIDING_CONTENT);

        //添加Fragment
        homeFragment = new HomeFragment();
        sunFragment = new SunFragment();
        guanZhuFragment = new GuanZhuFragment();
        myFragment = new MyFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_lay_frame, homeFragment,"hf");
        transaction.add(R.id.main_lay_frame, sunFragment,"sf");
        transaction.add(R.id.main_lay_frame, guanZhuFragment,"gf");
        transaction.add(R.id.main_lay_frame, myFragment,"mf");
        transaction.hide(sunFragment);
        transaction.hide(guanZhuFragment);
        transaction.hide(myFragment);

        transaction.commit();

        //默认选择第一个导航
        home.setSelected(true);

    }

    //初始化控件
    private void initView(){
        group = (RadioGroup) findViewById(R.id.main_lay_rg);
        home = (RadioButton) findViewById(R.id.main_lay_down_shouye);
        sun = (RadioButton) findViewById(R.id.main_lay_down_yang);
        guanzhu = (RadioButton) findViewById(R.id.main_lay_down_guanzhu);
        mys = (RadioButton) findViewById(R.id.main_lay_down_wode);
    }

    //Fragment之间的切换
    private void cutFragment(Fragment newFrag,Fragment oldFrag01,Fragment oldFrag02,Fragment oldFrag03){
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
                cutFragment(sunFragment,homeFragment,guanZhuFragment,myFragment);
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

        }
    }
}
