package com.asdsoft.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventsDescription extends AppCompatActivity {
    public View.OnClickListener onclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int n=Integer.parseInt(view.getTag().toString());
            setScreen(n);
        }
    };

    ImageView imageView;

    public void setScreen(int n)
    {
        TextView textView=findViewById(R.id.textView4);
        imageView.setBackground(null);
        imageView=findViewById(R.id.imageView14);
        switch(n)
        {
            case 1:
                imageView.setImageResource(R.drawable.nth1);
                imageView=findViewById(R.id.nth1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.blue);
                textView.setText("NTH description");
                break;
            case 2:
                imageView.setImageResource(R.drawable.ncc1);
                imageView=findViewById(R.id.ncc1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.blue);
                textView.setText("NCC description");
                break;
            case 3:
                imageView.setImageResource(R.drawable.ping);
                imageView=findViewById(R.id.ping1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.blue);
                textView.setText("PING description");
                break;
            case 4:
                imageView.setImageResource(R.drawable.enigma1);
                imageView=findViewById(R.id.enigma1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.blue);
                textView.setText("ENIGMA description");
                break;
            case 5:
                imageView.setImageResource(R.drawable.quiz1);
                imageView=findViewById(R.id.quiz1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.blue);
                textView.setText("QUIZ description");
                break;
            case 6:
                imageView.setImageResource(R.drawable.unravel1);
                imageView=findViewById(R.id.unravel1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.blue);
                textView.setText("Unravel description");
                break;
            default:
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_description);
        int n=getIntent().getIntExtra("number",1);
        imageView=findViewById(R.id.ncc1);//dummy
        ImageView imageview;
        imageview = findViewById(R.id.nth1);
        imageview.setOnClickListener(onclick);
        imageview=findViewById(R.id.ncc1);
        imageview.setOnClickListener(onclick);
        imageview=findViewById(R.id.unravel1);
        imageview.setOnClickListener(onclick);
        imageview=findViewById(R.id.ping1);
        imageview.setOnClickListener(onclick);
        imageview=findViewById(R.id.quiz1);
        imageview.setOnClickListener(onclick);
        imageview=findViewById(R.id.enigma1);
        imageview.setOnClickListener(onclick);
        setScreen(n);
    }
}
