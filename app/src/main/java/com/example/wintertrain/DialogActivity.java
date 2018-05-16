package com.example.wintertrain;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Show_Dialog_Button:
                showDialog();
                break;
            case R.id.Show_List_Dialog_hobby:
                showListDialog();
                break;
            case R.id.Show_one_Dialog_hobby:
                showOneDialog();
                break;
            case R.id.Show_Custom_Dialog:
                ShowPastDialog();
                break;
        }
    }

    private void ShowPastDialog() {

        View view= LayoutInflater.from(this)
                .inflate(R.layout.layout_custom_dialog,null,false);

        final AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("Custom Dialog")
                .setView(view)
                .create();

        final EditText input=view.findViewById(R.id.info_EditText);
        Button ok=view.findViewById(R.id.ok_Button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=input.getText().toString();
                Toast.makeText(DialogActivity.this, text, Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void showOneDialog() {
        final String[] strings={"游泳","羽毛球","绘画","唱歌"};
        final String[] string=new String[1];
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("选择你的爱好")
                .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        string[0]=strings[which];
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, string[0], Toast.LENGTH_SHORT).show();

                    }
                })
                .show();
    }

    private void showListDialog() {
        final String[] strings={"游泳","羽毛球","绘画","唱歌"};
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("选择你的爱好")
                .setItems(strings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s=strings[which];
                        Toast.makeText(DialogActivity.this,s,Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void showDialog() {
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("this is title")
                .setMessage("this is a message")
                //两个参数，第一个Button名称，第二个是Button点击事件
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }
}
