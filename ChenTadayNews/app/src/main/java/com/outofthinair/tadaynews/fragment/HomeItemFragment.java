package com.outofthinair.tadaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.outofthinair.tadaynews.R;
import com.outofthinair.tadaynews.adapter.HomeFragmentListAdapter;
import com.outofthinair.tadaynews.bean.GunggaoBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */

public class HomeItemFragment extends Fragment {

    private TextView textView;
    private ListView listView;

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
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }else if(name=="热点"){
            textView.setText("热点");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/?category=news_hot&refer=1&count=20&last_refresh_sub_entrance_interval=1489540467&" +
                    "loc_mode=5&loc_time=1489538964&latitude=23.001249999999995&longitude=101.56358166666665&city=普洱&tt_from=enter_auto&lac=34560&" +
                    "cid=32543&cp=5f89c8869f573q1&iid=8751701305&device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=606&" +
                    "version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%2C101533%2C109464%2C11034" +
                    "1%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%2C94045%2C112532%2C112101%2C1" +
                    "05610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&" +
                    "ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&os_version=4.4.2&" +
                    "uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540467513");
        }else if(name=="视频"){
            textView.setText("阳光");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/?category=video&refer=1&count=20&last_refresh_sub_entrance_interval=1489540595&loc_mode=5&" +
                    "loc_time=1489538964&latitude=23.001249999999995&longitude=101.56358166666665&city=普洱&tt_from=enter_auto&lac=34560&cid=32543&" +
                    "cp=5f8aca89905f3q1&iid=8751701305&device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=606&" +
                    "version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%2C101533%2C109464%2" +
                    "C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%2C94045%2C112532%2C112" +
                    "101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475&ab_client=a2%2Cc2%2Ce1%2Cf" +
                    "1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&os_version=4.4.2&" +
                    "uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540595899");
        }

        if (name=="社会"){
            textView.setText("社会");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/?category=news_society&concern_id=6215497899397089794&refer=1&count=20&min_behot_time=1489540790&" +
                    "last_refresh_sub_entrance_interval=1489540817&loc_mode=5&loc_time=1489538964&latitude=23.001249999999995&longitude=101.56358166666665&city=普洱" +
                    "&tt_from=click&lac=34560&cid=32543&cp=5b8bc486976d1q1&iid=8751701305&device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_" +
                    "article&version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%2C1015" +
                    "33%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%2C94045%2C112532%" +
                    "2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475&ab_client=a2%2Cc2%2Ce1%2Cf1%2C" +
                    "g2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&os_version=4.4.2&uuid=864394010080" +
                    "028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&" +
                    "dpi=320&update_version_code=6060&_rticket=1489540817739");
        }

        if (name=="娱乐"){
            textView.setText("娱乐");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }
        if (name=="图片"){
            textView.setText("图片");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/?concern_id=6286225228934679042&refer" +
                    "=1&count=20&min_behot_time=1489540025&last_refresh_sub_entrance_interval=1489540100&" +
                    "loc_mode=5&loc_time=1489538964&latitude=23.001249999999995&longitude=101.56358166666" +
                    "665&city=普洱&tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&devi" +
                    "ce_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=606" +
                    "&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C10178" +
                    "6%2C112146%2C111549%2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97" +
                    "143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%2C94045%2C112532%2C112101%2C10" +
                    "5610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C1" +
                    "05475&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type" +
                    "=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&os_version=4.4.2&uuid=864394010080028&" +
                    "openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&update_v" +
                    "ersion_code=6060&_rticket=1489540100356");
        }
        if (name=="汽车"){
            textView.setText("汽车体育财经");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }
        if (name=="体育"){
            textView.setText("体育");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }
        if (name=="财经"){
            textView.setText("财经");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }
        if (name=="趣图"){
            textView.setText("趣图");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }
        if (name=="美女"){
            textView.setText("美女");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
        }
        if (name=="段子"){
            textView.setText("段子");
            requseIntNet("http://lf.snssdk.com/api/news/feed/v51/" +
                    "?concern_id=6286225228934679042&refer=1&count=20&min_behot_time=1489540025&" +
                    "last_refresh_sub_entrance_interval=1489540100&loc_mode=5&loc_time=1489538964&" +
                    "latitude=23.001249999999995&longitude=101.56358166666665&city=%E6%99%AE%E6%B4%B1&" +
                    "tt_from=click&lac=34560&cid=32543&cp=5a84c68993404q1&iid=8751701305&" +
                    "device_id=35355507807&ac=wifi&channel=update&aid=13&app_name=news_article&" +
                    "version_code=606&version_name=6.0.6&device_platform=android&ab_version=96767%2C112377%2C111304%2C101786%2C112146%2C111549%" +
                    "2C101533%2C109464%2C110341%2C109891%2C112476%2C112071%2C106784%2C97143%2C31241%2C112530%2C111339%2C101558%2C104323%2C112165%" +
                    "2C94045%2C112532%2C112101%2C105610%2C112343%2C105824%2C111316%2C108976%2C108486%2C111897%2C110795%2C111418%2C98043%2C105475" +
                    "&ab_client=a2%2Cc2%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=102749%2C94563&ssmix=a&device_type=OPPO+A53m&device_brand=OPPO&language=zh&os_api=19&" +
                    "os_version=4.4.2&uuid=864394010080028&openudid=08002700DC950000&manifest_version_code=605&resolution=1080*1920&dpi=320&" +
                    "update_version_code=6060&_rticket=1489540100356");
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
        listView = (ListView) view.findViewById(R.id.home_item_frag_list);
    }

    //请求网络
    private void requseIntNet(String url){
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
                    JSONObject obj01=new JSONObject(result);
                    //第二层对象的data属性
                    if (obj01.has("data")){
                        ArrayList<JSONObject> list =new ArrayList<JSONObject>();
                        JSONArray list02=obj01.getJSONArray("data");
                        //遍历集合,的三层是一个对象
                        for (int i = 0; i <list02.length() ; i++) {
                            JSONObject obj02=list02.getJSONObject(i);
                            String json = obj02.getString("content");
                            JSONObject content=new JSONObject(json);
                            Log.d("数据解析------->",content.toString());
                            list.add(content);

                        }
                        Log.d("List------->",list.toString());

                        HomeFragmentListAdapter adapter = new HomeFragmentListAdapter(getActivity(),list);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

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
