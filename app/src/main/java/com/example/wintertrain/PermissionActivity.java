package com.example.wintertrain;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.request_permission_button:
//                if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                        != PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
//                }else {
//                    Toast.makeText(this, "已经同意所有权限", Toast.LENGTH_SHORT).show();
//                }
//                break;
//        }
        List<String> permissions=new ArrayList<>();
        //判断权限是否被授予
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.CAMERA);
        }
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.RECORD_AUDIO);
        }
        if(!permissions.isEmpty()){
            ActivityCompat.requestPermissions(this,
                    permissions.toArray(new String[permissions.size()]),1);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults.length>0){
                List<String> deniedPremission=new ArrayList<>();
                for(int i=0;i<permissions.length;i++){
                    if(grantResults[i]!=PackageManager.PERMISSION_GRANTED){
                        deniedPremission.add(permissions[i]);
                    }
                }
                if(!deniedPremission.isEmpty()){
                    Toast.makeText(this, "已经同意所有权限", Toast.LENGTH_SHORT).show();
                }else {
                    for(String deniedPermission:deniedPremission){
                        Toast.makeText(this, deniedPermission+"被拒绝", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}