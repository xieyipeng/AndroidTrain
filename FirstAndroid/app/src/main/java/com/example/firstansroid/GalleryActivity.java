package com.example.firstansroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 解奕鹏 on 2017/12/10.
 *
 * 快捷键  Ctrl + Alt + M
 *         shift + F6
 *
 */

public class GalleryActivity extends AppCompatActivity {

    private ImageView mGalleryImageView;
    private Button mPreviewButton;
    private Button mNextButton;
    private TextView mIndexTextView;

    private int[] images=new int[]{
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
    };

    int index=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mGalleryImageView = findViewById(R.id.gallery_view);
        mPreviewButton = findViewById(R.id.preview_Button);
        mNextButton = findViewById(R.id.next_Button);
        mIndexTextView = findViewById(R.id.index_text_view);

        updateUI();

        mPreviewButton.setOnClickListener(mListnner);
        mNextButton.setOnClickListener(mListnner);

    }
    private View.OnClickListener mListnner=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id=v.getId();
            switch (id){
                case R.id.preview_Button:
                    if(index!=0){
                        index--;
                    }else {
                        index=images.length-1;
                    }
                    updateUI();
                    break;
                case R.id.next_Button:
                    if(index!=images.length-1){
                        index++;
                    }else {
                        index=0;
                    }
                    updateUI();
                    break;
            }
        }
    };
    private void updateUI() {
        mGalleryImageView.setImageResource(images[index]);
        mIndexTextView.setText(String.format("%d/%d/",index+1,images.length));
    }
}
