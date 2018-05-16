package com.example.wintertrain;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LearnForAcyivity extends AppCompatActivity {

    private static final String TAG = "LearnForAcyivity";

    private Button textViewButton;
    private TextView LucknumberTextView;
    private final int RQUEST_FOR_LUCKY =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        Log.i(TAG,"on Create");

        textViewButton =findViewById(R.id.Test_Button);
        LucknumberTextView=findViewById(R.id.YunShi);

        textViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int lucky=random.nextInt(101);
                Intent intent=LuckyActivity.newIntent(LearnForAcyivity.this,lucky);
                //Intent intent=new Intent(LearnForAcyivity.this,LuckyActivity.class);
                //intent.putExtra("lucky",lucky);
                Log.i(TAG, "onClick: hello");
                startActivityForResult(intent, RQUEST_FOR_LUCKY);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"on Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"on Restart");
    }

    private final String EXTRA_SAVE="save_lucky";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: is called");
        String lucky=LucknumberTextView.getText().toString();
        outState.putString(EXTRA_SAVE,lucky);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: ");
        LucknumberTextView.setText(savedInstanceState.getString(EXTRA_SAVE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == RQUEST_FOR_LUCKY){
            String lucky=data.getStringExtra("lucky");
            LucknumberTextView.setText(lucky);
        }
    }
}