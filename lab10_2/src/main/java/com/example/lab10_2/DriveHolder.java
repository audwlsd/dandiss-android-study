package com.example.lab10_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// 한 항목의 View Xml 정보를 가지고 있는 객체
public class DriveHolder {

    public ImageView typeImageView;
    public TextView titleView;
    public TextView dateView;
    public ImageView menuImageView;

    public DriveHolder(View root) {
        typeImageView = root.findViewById(R.id.custom_item_type_image);
        titleView = root.findViewById(R.id.custom_item_title);
        dateView = root.findViewById(R.id.custom_item_date);
        menuImageView = root.findViewById(R.id.custom_item_menu);
    }
}
