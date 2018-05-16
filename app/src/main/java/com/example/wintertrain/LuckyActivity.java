package com.example.wintertrain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import java.util.Random;

/**
 * Created by 解奕鹏 on 2018/1/20.
 */

public class LuckyActivity extends AppCompatActivity {

    private static final String TAG = "LuckyAcyivity";
    private static final String EXTRA_LUCKY="lucky";
    private TextView luckNumberTextView;

    public static Intent newIntent(Context context,int lucky){
        Intent intent=new Intent(context,LuckyActivity.class);
        intent.putExtra(EXTRA_LUCKY,lucky);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: kaishi");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_for);

        luckNumberTextView=findViewById(R.id.Luck_Number_Text_View);

        int base=getIntent().getIntExtra(EXTRA_LUCKY,0);

        //shift+F6
        Random random=new Random();
        int lucky=base+random.nextInt(101);
        luckNumberTextView.setText(lucky+"");
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("lucky",luckNumberTextView.getText().toString());
        setResult(Activity.RESULT_OK,intent);
        super.onBackPressed();
    }
}
