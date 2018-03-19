package com.asdsoft.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class seminars extends android.app.Fragment {

    public ListView lv;
    public String[] s={
            "Civil Services Examination and Opportunities Workshop\n"
    };

    public seminars()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_seminars, container, false);
        lv=(ListView)v.findViewById(R.id.semlist);
        SeminarAdapter adapter=new SeminarAdapter(this,s);
        lv.setAdapter(adapter);
        final ViewGroup vg=container;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Bundle b=new Bundle();
                Intent description=new Intent(vg.getContext(),seminarActivity.class);

               if(i==0) {
                   b.putString("key","Civil Services Examination and Opportunities Workshop\n" +
                           "An opportunity to learn about one of the most competitive and sought after exam in India.\n" +
                           "\n" +
                           "Conducted by Industry Experts, get first hand experience with a platform to clear all your doubts and broaden your horizons.\n" +
                           "\n" +
                           "Tips and guidance will be given about how to crack exams like UPSC, MPSC etc and shape your career.\n" +
                           "\n" +
                           "Registration Fee: Free Workshop\n" +
                           "\n" +
                           "Venue - Computer Seminar Hall, PICT, Pune\n" +
                           "\n" +
                           "Workshop Date- Thursday, 22nd February, 2018\n" +
                           "\n" +
                           "Workshop Timing- 4:00 PM to 5:30 PM");
                   b.putInt("imgid", R.drawable.img1);
               }
                description.putExtras(b);
                startActivity(description);


            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
