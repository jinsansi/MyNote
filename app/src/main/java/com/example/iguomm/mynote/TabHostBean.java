package com.example.iguomm.mynote;

/**
 * Created by iGuomm on 2016/11/14.
 */

public class TabHostBean {

    private Class fragment;
    private String title = null;
    private int icon;

    public TabHostBean(Class fragment, String title, int icon) {
        this.fragment = fragment;
        this.title = title;
        this.icon = icon;
    }
    public TabHostBean(Class fragment, int icon) {
        this.fragment = fragment;
        this.title = title;
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
