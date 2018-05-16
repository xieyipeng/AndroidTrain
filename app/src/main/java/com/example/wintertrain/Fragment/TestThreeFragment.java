package com.example.wintertrain.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wintertrain.R;

/**
 * Created by 解奕鹏 on 2018/1/21.
 */

public class TestThreeFragment extends Fragment{

    private TextView numberTextView;
    private Button addButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numberTextView = view.findViewById(R.id.number_test_view);
        addButton = view.findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=numberTextView.getText().toString();
                int newNumber= Integer.valueOf(number)+1;
                numberTextView.setText(newNumber+"");
            }
        });
        LinearLayout linearLayout=view.findViewById(R.id.linear_layout);
        linearLayout.setBackgroundColor(Color.RED);
    }
}
