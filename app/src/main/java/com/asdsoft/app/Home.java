package com.asdsoft.app;

//import android.app.FragmentManager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class Home extends android.app.Fragment implements View.OnClickListener {

    private FragmentActivity myContext;

    int[] sampleImages = {R.drawable.img3, R.drawable.img4, R.drawable.img5};
    CarouselView carouselView;
    Button btn1,btn2,btn3;

    public Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);

        btn1=(Button)v.findViewById(R.id.ctd);
        btn2=(Button)v.findViewById(R.id.pisb);
        btn3=(Button)v.findViewById(R.id.ieee);

        btn1.setOnClickListener(this);


        carouselView = (CarouselView) v.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
        return v;
    }

    @Override
    public void onClick(View view)
    {
        if(view==btn1)
        {
            getActivity().getFragmentManager().popBackStack();
            getActivity().getFragmentManager().beginTransaction().addToBackStack(null);
            getActivity().getFragmentManager().beginTransaction().replace(R.id.frame, new TabFragment()).commit();
            //myContext.getFragmentManager().popBackStack();
            //myContext.getFragmentManager().beginTransaction().addToBackStack(null);
            //myContext.getFragmentManager().beginTransaction().replace(R.id.frame,new TabFragment()).commit();
            //getChildFragmentManager().popBackStack();
            //getChildFragmentManager().beginTransaction().addToBackStack(null);
            //getChildFragmentManager().beginTransaction().replace(R.id.frame,new TabFragment()).commit();

        }
        if(view==btn2)
        {

        }
        if(view==btn3)
        {

        }

    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }

    };

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}




