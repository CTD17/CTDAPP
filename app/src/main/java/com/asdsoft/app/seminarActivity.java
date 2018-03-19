package com.asdsoft.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class seminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);
        String s="Workshop on Civil Services";
        TextView tv;
        tv=(TextView)findViewById(R.id.tv);
        tv.setText(s);
    }
}
