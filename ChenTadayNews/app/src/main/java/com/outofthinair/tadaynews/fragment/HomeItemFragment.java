package com.outofthinair.tadaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.outofthinair.tadaynews.R;

import org.w3c.dom.Text;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/3/10.
 */

public class HomeItemFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.home_item_frag_layout,null);
        itinView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String name =bundle.get("name").toString();
        if (name=="推荐"){
            textView.setText("推荐");
        }else if(name=="热点"){
            textView.setText("热点");
        }else if(name=="视频"){
            textView.setText("阳光");
        }

        if (name=="社会"){
            textView.setText("社会");
        }

        if (name=="娱乐"){
            textView.setText("娱乐");
        }
        if (name=="图片"){
            textView.setText("图片");
        }
        if (name=="汽车"){
            textView.setText("汽车体育财经");
        }
        if (name=="体育"){
            textView.setText("体育");
        }
        if (name=="财经"){
            textView.setText("财经");
        }
        if (name=="趣图"){
            textView.setText("趣图");
        }
        if (name=="美女"){
            textView.setText("美女");
        }
        if (name=="段子"){
            textView.setText("段子");
        }

    }

    //生成Fragment的静态方法
    public static HomeItemFragment getNewFragment(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        HomeItemFragment homeItemFragment = new HomeItemFragment();
        homeItemFragment.setArguments(bundle);

        return homeItemFragment;
    }

    private void itinView(View view){
        textView = (TextView) view.findViewById(R.id.home_item_frag_text);
    }

    //请求网络
    private void requseIntNet(String url){
        RequestParams params = new RequestParams(url);
        params.setCacheMaxAge(1000*3600);

        x.http().get(params, new Callback.CacheCallback<String>() {

            private String result;//接受一下缓存的数据
            //成功时调用
            @Override
            public void onSuccess(String result) {
                if (result==null){
                    this.result=result;
                }

            }
            //错误时调用
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            //缓存时调用
            @Override
            public boolean onCache(String result) {
                this.result=result;
                //返回true 允许缓存
                return true;
            }
        });
    }

}
