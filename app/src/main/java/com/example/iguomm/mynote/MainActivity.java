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

        //获取控件
        FragmentTabHost tabHost  = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //加载Fragment的承载布局
        tabHost.setup(this,getSupportFragmentManager(),R.id.main_content);
        //设置去掉分割线，第一个为主页
        tabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabHost.setCurrentTab(0);
        //定义一个Fragment，一个存放图片，存放文字的集合
        List<Class> fragments = new ArrayList<>();
        fragments.add(HomeFragment.class);
        fragments.add(TwoFragment.class);
        fragments.add(WriteFragment.class);
        fragments.add(FourFragment.class);
        fragments.add(MineFragment.class);
        //
        int[] images = new int[]{
                R.drawable.ic, R.drawable.ic, R.mipmap.zw_icon_tjzhuanti_click, R.drawable.ic, R.drawable.ic,
        };
        //
        String[] titles = new String[]{
                "发现","关注","","消息","我的"
        };
        //加载布局
        for(int i = 0; i < 5; i++){
            View view = LayoutInflater.from(this).inflate(R.layout.tabhost,null,false);
            ImageView iamge = (ImageView) view.findViewById(R.id.tab_image);
            TextView title = (TextView) view.findViewById(R.id.tab_title);
            if( titles[i].isEmpty()){
                title.setVisibility(View.GONE);
            }
            title.setText(titles[i]);
            iamge.setBackgroundResource(images[i]);
            tabHost.addTab(tabHost.newTabSpec(titles[i]).setIndicator(view),fragments.get(i),null);
        }






    }
}
