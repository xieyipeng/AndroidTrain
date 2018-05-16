package com.example.wintertrain.Fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wintertrain.Fragment.TestOneFragment;
import com.example.wintertrain.R;
import com.example.wintertrain.base.FragmentContainerActivity;

public class LearnFranmentActivity extends FragmentContainerActivity {
    //        setContentView(R.layout.activity_learn__franment_);
    //        getSupportFragmentManager().beginTransaction()
    //                .add(R.id.fragment_container,new TestOneFragment())
    //                .commit();
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_learn__franment_;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    protected Fragment createFragment() {
        return new TestOneFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
}
