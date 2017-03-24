package com.outofthinair.tadaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.adapter.HomeFragmentListAdapter;
import com.outofthinair.tadaynews.adapter.ShiPinAdapter;
import com.outofthinair.tadaynews.bean.ShiPinBean;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/14.
 */

public class SunItemFragment extends Fragment{

    private TextView textView;
    // 热点视频
    public static final String VIDEO_HOT_ID ="V9LG4B3A0";
    // 娱乐视频
    public static final String VIDEO_ENTERTAINMENT_ID = "V9LG4CHOR";
    // 搞笑视频
    public static final String IDEO_FUN_ID = "V9LG4E6VR";
    // 精品视频
    public static final String  VIDEO_CHOICE_ID ="00850FRB";
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sun_item_frag_layout,null);
        textView = (TextView) view.findViewById(R.id.sun_item_lay_text);
        listView = (ListView) view.findViewById(R.id.sun_item_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        if (name.equals("推荐")){
            textView.setText("推荐");
            requseIntNet(VIDEO_HOT_ID);
        }

        if (name.equals("音乐")){
            textView.setText("音乐");
            requseIntNet(VIDEO_ENTERTAINMENT_ID);
        }

        if (name.equals("搞笑")){
            textView.setText("搞笑");
            requseIntNet(IDEO_FUN_ID);
        }

        if (name.equals("社会")){
            textView.setText("社会");
            requseIntNet(VIDEO_CHOICE_ID);
        }

        if (name.equals("小品")){
            textView.setText("小品");
            requseIntNet(VIDEO_ENTERTAINMENT_ID);
        }

        if (name.equals("生活")){
            textView.setText("生活");
            requseIntNet(IDEO_FUN_ID);
        }

        if (name.equals("影视")){
            textView.setText("影视");
            requseIntNet(VIDEO_CHOICE_ID);
        }

        if (name.equals("娱乐")){
            textView.setText("娱乐");
            requseIntNet(VIDEO_ENTERTAINMENT_ID);
        }

        if (name.equals("呆萌")){
            textView.setText("呆萌");
            requseIntNet(IDEO_FUN_ID);
        }

        if (name.equals("游戏")){
            textView.setText("游戏");
            requseIntNet(VIDEO_CHOICE_ID);
        }

        if (name.equals("开眼")){
            textView.setText("开眼");
            requseIntNet(IDEO_FUN_ID);
        }

        if (name.equals("再看一遍")){
            textView.setText("再看一遍");
            requseIntNet(VIDEO_ENTERTAINMENT_ID);
        }

        if (name.equals("火山直播")){
            textView.setText("火山直播");
            requseIntNet(VIDEO_CHOICE_ID);
        }

        if (name.equals("原创")){
            textView.setText("原创");
            requseIntNet(VIDEO_ENTERTAINMENT_ID);
        }

    }

    public static SunItemFragment getSunItemFragment(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        SunItemFragment sunItemFragment = new SunItemFragment();
        sunItemFragment.setArguments(bundle);
        return sunItemFragment;
    }

    //请求网络
    private void requseIntNet(final String id){
        String url= "http://c.3g.163.com/nc/video/list/"+id+"/n/10-10.html";
        RequestParams params = new RequestParams(url);
        params.setCacheMaxAge(1000*600);

        x.http().get(params, new Callback.CacheCallback<String>() {

            private String Myresult;
            @Override
            public void onSuccess(String result) {

                if (result==null){
                    this.Myresult=result;
                }

                //数据解析,预计采用JSONobject+JavaBean
                try {
                    //第一层是个对象
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray(id);
                    ArrayList<ShiPinBean> list = new ArrayList<ShiPinBean>();
                    for (int i = 0; i <jsonArray.length() ; i++) {
                        Log.d("ffffffff",jsonArray.getJSONObject(i).toString());
                        Gson g = new Gson();
                        ShiPinBean shiPinBean = g.fromJson(jsonArray.getJSONObject(i).toString(), ShiPinBean.class);

                        list.add(shiPinBean);


                    }
                    ShiPinAdapter adapter = new ShiPinAdapter(getActivity(),list);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                this.Myresult=result;
                return false;
            }
        });

    }
}

