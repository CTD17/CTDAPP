package com.asdsoft.app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.asdsoft.app.Event.imageView1;

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
        ScrollView scrollView=findViewById(R.id.scrollView2);
        TextView textView=findViewById(R.id.textView4);
        imageView.setBackground(null);
        imageView=findViewById(R.id.imageView14);
        switch(n)
        {
            case 1:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                imageView.setImageResource(R.drawable.nth1);
                imageView=findViewById(R.id.nth1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.highlight1);
                textView.setText("Tune into Network Treasure Hunt, an online treasure hunt where participants read between the lines, connect the dots and dig into the internet to solve the riddles.\n" +
                        "Bring out the Sherlock in you to crack a series of strategic clues and get ready to plunge into the world of deductions.\n" +
                        "Explore Google, decode the hints and follow the trail to Decrypt the Encrypted!\n" +
                        "So go on, log in and unfold the mysteries in these 36 hours long run.\n" +
                        "\nThe game is on!\n" +
                        "\nNTH goes live on: 17th February 2018\n" +
                        "\nTimings: 9:00pm IST\n" +
                        "\nVisit: https://nth.credenz.info");
                break;
            case 2:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                imageView.setImageResource(R.drawable.ncc1);
                imageView=findViewById(R.id.ncc1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.highlight1);
                textView.setText("Are you crazy about ALGORITHMS?\n" +
                        "Here's an opportunity to divulge into the intricacies of competitive coding. PISB brings you NCC (National Computing Contest).\n" +
                        "NCC is a platform where you can not only test your logical acuity but also explore your coding skills.\n" +
                        "So, get ready to brainstorm your knowledge of C and C++ to code, compile and resolve.\n" +
                        "\nDate: Tuesday, 27th Feburary, 2018\n" +
                        "Venue: Pune Institute of Computer Technology (PICT), Pune.\n" +
                        "\nRegistration Fee : 100Rs (Team of 2 max)\n" +
                        "\nFor further details, contact\n" +
                        "Ayush Gupta : 9028600226\n" +
                        "Amey Deshpande : 7588758032");
                break;
            case 3:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                imageView.setImageResource(R.drawable.ping);
                imageView=findViewById(R.id.ping1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.highlight1);
                textView.setText("P.I.N.G. (PICT IEEE Newsletter Group) is the official technical magazine of PISB published twice a year. P.I.N.G. serves as a platform for individuals to portray their technical ingenuity. It highlights articles on cutting-edge technologies from technocrats all around the globe including students, industrialists and faculty members. It also features interviews of distinguished personalities in various technical domains.\n" +
                        "P.I.N.G. aims at keeping its readers up to date on recent developments in technology and helps them extrapolate their perceptions to contemporary ideas of modernisation.\n" +
                        "With the imminent Issue 14.0, be ready to get P.I.N.G.'d!");
                break;
            case 4:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                imageView.setImageResource(R.drawable.enigma1);
                imageView=findViewById(R.id.enigma1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.highlight1);
                textView.setText("Hello Everyone! PISB presents you the very first event of CTD'18 Enigma-\n The Battle For Logical Supremacy*\n" +
                        "Do you have what it takes to face the mind boggling questions which will push your logical reasoning to its limit?! Then don't miss on this amazing opportunity.\n" +
                        "\nDate : Tuesday, 16th Jan 2018!\n" +
                        "\nFee : Rs. 30/Team(of Two)\n" +
                        "\nTime : 4:00 PM First Shift\n" +
                        "8:00 PM Second Shift\n" +
                        "\nContact and Paytm\n" +
                        "Aman Goenka : 8983723300");
                break;
            case 5:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                imageView.setImageResource(R.drawable.quiz1);
                imageView=findViewById(R.id.quiz1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.highlight1);
                textView.setText("Rack your brains and put your mind to the test as you participate in InQuizitive, a quiz held jointly by PISB and PICT Quiz Club.\n" +
                        "Join us for a session of brain teasers that are worded to amuse and amaze.\n" +
                        "Get ready to put your thinking caps and exercise those grey cells!\n" +
                        "\nTime: 4:00 pm\n" +
                        "\nRack your brains and put your mind to the test as you participate in InQuizitive, a quiz held jointly by PISB and PICT Quiz Club.\n" +
                        "\nJoin us for a session of brain teasers that are worded to amuse and amaze.\n" +
                        "\nGet ready to put your thinking caps and exercise those grey cells!\n" +
                        "\nDate will be announced soon! ");
                break;
            case 6:
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                imageView.setImageResource(R.drawable.unravel1);
                imageView=findViewById(R.id.unravel1);
                imageView.getParent().requestChildFocus(imageView,imageView);
                imageView.setBackgroundResource(R.drawable.highlight1);
                textView.setText("Do you have a knack to solve riddles?\n" +
                        "PISB brings you Unravel - The On Campus Treasure Hunt!\n" +
                        "\nIf you ever thought of PICT campus being small, get ready to change your thoughts.\n" +
                        "\nFollow the trail to reach the ultimate treasure! The fun and excitement in the competition increases as you solve the puzzles and move to the next level. Its all about speed and logic.\n" +
                        "\nPack your binoculars, wear your running shoes and let your team's flag shine at the top.\n" +
                        "\nDate will be announced soon! ");
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
