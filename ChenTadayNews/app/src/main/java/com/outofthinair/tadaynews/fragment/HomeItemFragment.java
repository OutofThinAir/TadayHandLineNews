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
        }else if(name=="阳光"){
            textView.setText("阳光");
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
}
