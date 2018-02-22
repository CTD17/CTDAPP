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

        Bundle b;

        b=getIntent().getExtras();

        String s=b.getString("key");
        int i=b.getInt("imgid");

        TextView tv;
        tv=(TextView)findViewById(R.id.info);

        ImageView iv;
        iv=(ImageView)findViewById(R.id.imageView2);

        iv.setImageResource(i);
        tv.setText(s);
    }
}
