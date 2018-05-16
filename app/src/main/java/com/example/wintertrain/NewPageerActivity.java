package com.example.wintertrain;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wintertrain.Fragment.TestFourFragment;
import com.example.wintertrain.Fragment.TestOneFragment;
import com.example.wintertrain.Fragment.TestThreeFragment;
import com.example.wintertrain.Fragment.TestTwoFragment;
import com.example.wintertrain.adapter.ViewPageAdapter;

public class NewPageerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ViewPageAdapter mAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pageer);

        mViewPager=findViewById(R.id.view_paper);
        mTabLayout=findViewById(R.id.tab_layout);

        String[] title={"Test One","Test Two","Test Three","Test Four"};
        mAdopter=new ViewPageAdapter(getSupportFragmentManager(),title);

        //添加
        mAdopter.addFragment(new TestOneFragment());
        mAdopter.addFragment(new TestTwoFragment());
        mAdopter.addFragment(new TestThreeFragment());
        mAdopter.addFragment(new TestFourFragment());

        //viewPaper和tabLayout关联
        mViewPager.setAdapter(mAdopter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }
}
