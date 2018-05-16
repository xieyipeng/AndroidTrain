package com.example.firstansroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 解奕鹏 on 2017/12/10.
 *
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mUsermanEditText;
    private EditText mPasserwordEditText;
    private Button mSignInButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsermanEditText = findViewById(R.id.userman_edittest);
        mPasserwordEditText = findViewById(R.id.password_edittext);
        mSignInButton = findViewById(R.id.sign_in_button);

        mSignInButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.sign_in_button){
            String username=mUsermanEditText.getText().toString();
            String paserword=mPasserwordEditText.getText().toString();
//            if(!username.equals("")||!paserword.equals("")){
//
//            }
            if(!TextUtils.isEmpty(username)||!TextUtils.isEmpty(paserword)){
                if(username.equals(paserword)){
                    Toast.makeText(LoginActivity.this,"login successfully!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Failed to login!",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(LoginActivity.this,"please input the username and password!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
