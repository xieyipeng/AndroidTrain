package com.example.wintertrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wintertrain.adapter.RecycleAdopter;
import com.example.wintertrain.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //初始化
        mRecyclerView=findViewById(R.id.recycle_view);
        //如何排布（布局）
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //初始化Adopter
        List<User> users=new ArrayList<>();
        Random random=new Random();
        for (int i=0;i<100;i++){
            users.add(new User("username"+i,random.nextInt(50)));
        }
        RecycleAdopter adopter=new RecycleAdopter(users);
        //把adopter设置给RecycleView
        mRecyclerView.setAdapter(adopter);
        //创建 RecycleView 的点击事件
        adopter.setmOnItemClickListener(new RecycleAdopter.OnItemClickListener() {
            @Override
            public void onClick(User user) {
                Toast.makeText(RecycleViewActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycle_view,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.vertical:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.horizontal:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,false));
                break;
            case R.id.two_columns:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
