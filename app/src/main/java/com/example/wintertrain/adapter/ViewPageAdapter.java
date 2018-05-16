package com.example.wintertrain.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 解奕鹏 on 2018/1/21.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments=new ArrayList<>();
    String[] titles;

    public ViewPageAdapter(FragmentManager fm,String[] titles) {
        super(fm);
        this.titles=titles;
    }

    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}