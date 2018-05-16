package com.example.wintertrain.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 解奕鹏 on 2018/1/21.
 */

public abstract class FragmentContainerActivity extends AppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutResId();

    @IdRes
    protected abstract int getFragmentContainerId();

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(getFragmentContainerId());

        if (null == fragment) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(getFragmentContainerId(), fragment)
                    .commit();
        }
    }
}
