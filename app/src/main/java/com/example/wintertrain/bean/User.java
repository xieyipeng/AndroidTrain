package com.example.wintertrain.bean;

/**
 * Created by 解奕鹏 on 2018/1/21.
 */

public class User {

    private String userman;
    private int age;

    //构造函数
    public User(String userman, int age) {
        this.userman = userman;
        this.age = age;
    }

    public String getUserman() {
        return userman;
    }

    public void setUserman(String userman) {
        this.userman = userman;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userman='" + userman + '\'' +
                ", age=" + age +
                '}';
    }
}
