package com.example.wintertrain.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 解奕鹏 on 2018/1/21.
 */

public class RequsePermission {

    public static void requsePermission(Activity activity,String[] permissions){
//        List<String> permissionList=new ArrayList<>();
//        for (int i = 0; i < permissions.length; i++) {
//            if(ContextCompat.checkSelfPermission(activity,permissions[i])
//                    != PackageManager.PERMISSION_GRANTED){
//                permissionList.add(permissions[i]);
//            }
//        }
//        if(!permissionList.isEmpty()){
//            ActivityCompat.requestPermissions(this,
//                    permissionList.toArray(new String[permissions.size()]),1);
//        }

    }
}
