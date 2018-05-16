package com.example.wintertrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.wintertrain.Fragment.LearnFranmentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialog_activity:
                startActivity(new Intent(this,DialogActivity.class));
                break;
            case R.id.Lucky_Learn:
                startActivity(new Intent(this,LearnForAcyivity.class));
                break;
            case R.id.fragment_learning:
                startActivity(new Intent(this,LearnFranmentActivity.class));
                break;
            case R.id.view_pager_activity:
                startActivity(new Intent(this,NewPageerActivity.class));
                break;
            case R.id.Permission:
                startActivity(new Intent(this,PermissionActivity.class));
                break;
            case R.id.menu_learn:
                startActivity(new Intent(this,MenuActivity.class));
                break;
            case R.id.recycle_view_activity:
                startActivity(new Intent(this,RecycleViewActivity.class));
                break;
        }
    }


}
