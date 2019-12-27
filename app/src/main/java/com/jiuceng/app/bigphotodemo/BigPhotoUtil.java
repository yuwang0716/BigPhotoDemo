package com.jiuceng.app.bigphotodemo;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.ortiz.touchview.TouchImageView;


/**
 * Description :
 *
 * @author tao
 * @date 2019/12/27
 */
public class BigPhotoUtil {

    private static AlertDialog dialog;

    /**
     * 点击查看大图
     */
    public static void imgMax(Context context, Drawable drawable) {

        LinearLayout imgEntryView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dialog_photo_big,null);
        dialog = new AlertDialog.Builder(context).create();

        TouchImageView img = imgEntryView.findViewById(R.id.imageView);
        img.setImageDrawable(drawable);

        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        dialog.addContentView(imgEntryView,layoutParams);
        dialog.getWindow().getDecorView().setPadding(0,40,0,40);

        //状态栏透明化
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            dialog.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

    }
}
