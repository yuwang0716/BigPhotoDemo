package com.jiuceng.app.bigphotodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toMax(View view) {
        ImageView imageView = (ImageView) view;
        BigPhotoUtil.imgMax(this,imageView.getDrawable());
    }
}
