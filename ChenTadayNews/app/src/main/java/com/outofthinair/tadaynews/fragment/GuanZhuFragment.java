package com.outofthinair.tadaynews.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.activity.ParticularsActivity;
import com.outofthinair.tadaynews.adapter.ShouCangListAdapter;
import com.outofthinair.tadaynews.bean.ShouCangBean;
import com.outofthinair.tadaynews.bean.UserBean;
import com.outofthinair.tadaynews.sqlite.MySqLite;
import com.outofthinair.tadaynews.util.SqlUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/10.
 */

public class GuanZhuFragment extends Fragment {

    private SQLiteDatabase database;
    private ListView listView;
    private ArrayList<ShouCangBean> sList;
    private ShouCangListAdapter adapter;
    private TextView textView01;
    private TextView textView02;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guan_frag_layout,null);
        //初始化界面
        listView = (ListView) view.findViewById(R.id.guan_frag_list);
        textView01 = (TextView) view.findViewById(R.id.guan_frag_text01);
        textView02 = (TextView) view.findViewById(R.id.guan_frag_text02);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final MySqLite sqLite = new MySqLite(getActivity());
        database = sqLite.getWritableDatabase();

        //listView长按删除
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                //弹出一般对话框
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("你确定删除此条目吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除数据库
                        SqlUtil.deleteShoucang(database,sList.get(position).get_id());
                        sList.remove(sList.get(position));
                        adapter.notifyDataSetChanged();
                        builder.create().dismiss();
                        if (sList.size()==0){
                            listView.setVisibility(View.GONE);
                            textView01.setVisibility(View.VISIBLE);

                        }else{
                            listView.setVisibility(View.VISIBLE);
                            textView01.setVisibility(View.GONE);
                        }
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.create().dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });

        //点击跳转到详情页
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ParticularsActivity.class);
                intent.putExtra("url",sList.get(position).getParticularsUrl());
                getActivity().startActivity(intent);
            }
        });


    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            UserBean userBean=new UserBean();
            SqlUtil.queryByLoginToUser(database,"1",userBean);
            if (userBean.getUname()!=null){
                listView.setVisibility(View.VISIBLE);
                textView02.setVisibility(View.GONE);
                textView01.setVisibility(View.GONE);
                //查询数据库
                ArrayList<ShouCangBean> list = new ArrayList<>();
                SqlUtil.queryShouCang(database,list);

                sList = new ArrayList<>();

                //倒叙遍历集合,后来居上

                for (int i = list.size()-1; i>=0 ; i--) {
                    sList.add(list.get(i));
                }

                //设置适配器
                adapter = new ShouCangListAdapter(getActivity(), sList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                //是否有收藏
                if (list.size()==0){
                    textView01.setVisibility(View.VISIBLE);
                }else{
                    textView01.setVisibility(View.GONE);
                }
            }else{
                listView.setVisibility(View.GONE);
                textView02.setVisibility(View.VISIBLE);
                textView01.setVisibility(View.GONE);
            }


        }else{

        }
    }
}
