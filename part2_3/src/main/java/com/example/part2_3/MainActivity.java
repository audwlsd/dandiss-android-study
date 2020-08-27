package com.example.part2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);

        Button button1=new Button(this);
        button1.setText("button1");
        linearLayout.addView(button1);

        Button button2=new Button(this);
        button2.setText("button2");
        linearLayout.addView(button2);

        setContentView(linearLayout);
    }
}
