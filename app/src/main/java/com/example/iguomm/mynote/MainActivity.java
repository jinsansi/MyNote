package com.example.iguomm.mynote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iguomm.mynote.fragment.FourFragment;
import com.example.iguomm.mynote.fragment.HomeFragment;
import com.example.iguomm.mynote.fragment.MineFragment;
import com.example.iguomm.mynote.fragment.TwoFragment;
import com.example.iguomm.mynote.fragment.WriteFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabHost();
    }

    public void initTabHost(){
        //获取控件
        FragmentTabHost tabHost  = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //加载Fragment的承载布局
        tabHost.setup(this,getSupportFragmentManager(),R.id.main_content);
        //设置去掉分割线，第一个为主页
        tabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabHost.setCurrentTab(0);

        List<TabHostBean> tab = new ArrayList<>();
        tab.add(new TabHostBean(HomeFragment.class,"发现",R.drawable.ic));
        tab.add(new TabHostBean(TwoFragment.class,"关注",R.drawable.ic));
        tab.add(new TabHostBean(WriteFragment.class,R.mipmap.zw_icon_tjzhuanti_click));
        tab.add(new TabHostBean(FourFragment.class,"消息",R.drawable.ic));
        tab.add(new TabHostBean(MineFragment.class,"我的",R.drawable.ic));

        //加载布局
        for(int i = 0; i < tab.size(); i++){
            View view = LayoutInflater.from(this).inflate(R.layout.tabhost,null,false);
            ImageView iamge = (ImageView) view.findViewById(R.id.tab_image);
            TextView title = (TextView) view.findViewById(R.id.tab_title);
            String titles = tab.get(i).getTitle();
            if(titles.isEmpty()){
                title.setVisibility(View.GONE);
            }
            title.setText(titles);
            iamge.setBackgroundResource(tab.get(i).getIcon());
            tabHost.addTab(tabHost.newTabSpec(titles).setIndicator(view),tab.get(i).getFragment(),null);
        }

    }
}
