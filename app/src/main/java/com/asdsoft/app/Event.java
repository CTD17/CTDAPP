package com.asdsoft.app;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Event extends android.app.Fragment {
    public static ImageView imageView1;
    public View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getActivity().getApplicationContext(),EventsDescription.class);
            intent.putExtra("number",Integer.parseInt(view.getTag().toString()));
            startActivity(intent);
        }
    };

    public Event() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        imageView1 = view.findViewById(R.id.nth);
        imageView1.setOnClickListener(onClickListener);
        imageView1=view.findViewById(R.id.ncc);
        imageView1.setOnClickListener(onClickListener);
        imageView1=view.findViewById(R.id.unravel);
        imageView1.setOnClickListener(onClickListener);
        imageView1=view.findViewById(R.id.ping);
        imageView1.setOnClickListener(onClickListener);
        imageView1=view.findViewById(R.id.inquizitive);
        imageView1.setOnClickListener(onClickListener);
        imageView1=view.findViewById(R.id.enigma);
        imageView1.setOnClickListener(onClickListener);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle SavedInstanceState){
        LinearLayout linearLayout = getView().findViewById(R.id.ll);
        linearLayout.post(new Runnable()
        {
            public void run()
            {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int height = displayMetrics.heightPixels;
                int width = displayMetrics.widthPixels;
                LinearLayout linearLayout =  getView().findViewById(R.id.ll);
                height = linearLayout.getHeight();
                linearLayout =  getView().findViewById(R.id.ll1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(width, height / 4));
                linearLayout =  getView().findViewById(R.id.ll2);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(width, height / 4));
                linearLayout =  getView().findViewById(R.id.ll3);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(width, height / 4));
                linearLayout =  getView().findViewById(R.id.ll4);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(width, height / 4));
            }
        });
    }

}
