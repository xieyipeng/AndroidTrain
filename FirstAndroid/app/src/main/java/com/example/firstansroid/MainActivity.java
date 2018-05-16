package com.example.firstansroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * 变量名前加 m 表示变量是私有
     * 加 s 是静态
     */

    private TextView mNumberTextView;
    private Button mAddButton;
    private Button mSubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberTextView=findViewById(R.id.number_TextView);
        mAddButton=findViewById(R.id.add_Button);
        mSubButton=findViewById(R.id.sub_Button);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=mNumberTextView.getText().toString();
                mNumberTextView.setText(Integer.valueOf(num)+1+"");
            }
        });
        mSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=mNumberTextView.getText().toString();
                mNumberTextView.setText(Integer.valueOf(num)-1+"");
            }
        });
    }
}
