package com.outofthinair.tadaynews.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.outofthinair.tadaynews.bean.ShouCangBean;
import com.outofthinair.tadaynews.bean.UserBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/23.
 */

public class SqlUtil {

    public static void insertShoucan(SQLiteDatabase database,String title,String info,String picUrl,String vdUrl){
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("info",info);
        if (picUrl!=null){
            values.put("picurl",picUrl);

        }
        if (vdUrl!=null){
            values.put("partiurl",vdUrl);
        }

        database.insert("shoucang",null,values);
    }

    public static void queryShouCang(SQLiteDatabase database, ArrayList<ShouCangBean> list){
        String [] ziduan={"_id","title","info","picurl","partiurl"};
        Cursor cursor = database.query("shoucang", ziduan, null, null, null, null, null);

        while (cursor.moveToNext()){

            ShouCangBean shouCangBean =new ShouCangBean();
            int id =cursor.getInt(0);
            shouCangBean.set_id(id);
            String title=cursor.getString(1);
            shouCangBean.setTitle(title);
            String info=cursor.getString(2);
            shouCangBean.setInfo(info);
            if (cursor.getString(3)!=null){
                shouCangBean.setPicUrl(cursor.getString(3));
            }
            String partiUrl = cursor.getString(4);
            shouCangBean.setParticularsUrl(partiUrl);

           list.add(shouCangBean);

        }

    }

    //删除数据库
    public static void deleteShoucang(SQLiteDatabase database,int id){
      String sql = "delete from shoucang where _id="+id;
        database.execSQL(sql);
    }

    //user表添加
    public static void insertUser(SQLiteDatabase database,String uname,String headPic,String login){
        ContentValues values = new ContentValues();
        values.put("uname",uname);
        values.put("picurl",headPic);
        values.put("logig",login);
        database.insert("user",null,values);
    }

    //根据登录状态查询
    public static void queryByLoginToUser(SQLiteDatabase database, String lagin, UserBean userBean){
        String sql = "select * from user where logig='"+lagin+"'";
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            userBean.setId(id);
            String uname=cursor.getString(1);
            userBean.setUname(uname);
            String picUrl=cursor.getString(2);
            userBean.setHeadPic(picUrl);
            String login=cursor.getString(3);
            userBean.setLogin(login);
        }
    }

    //修改登录状态
    public static void updateLogin(SQLiteDatabase database,String uname,String login){
        String sql = "update user set logig ='"+login+"' where uname='"+uname+"'";
        database.execSQL(sql);

    }

    //修改用户头像
    public static void updateHeadUrl(SQLiteDatabase database,String uname,String hUrl){
        String sql="update user set picurl='"+hUrl+"' where uname='"+uname+"'";
        database.execSQL(sql);
    }
}
