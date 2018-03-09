package com.asdsoft.app;

//import android.app.FragmentManager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import in.shadowfax.proswipebutton.ProSwipeButton;


public class Home extends android.app.Fragment implements View.OnClickListener {

    private FragmentActivity myContext;

    int[] sampleImages = {R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3};
    CarouselView carouselView;
    Button btn1,btn2,btn3;

    public Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);

      //  btn1=(Button)v.findViewById(R.id.ctd);
       // btn1.setOnClickListener(this);


        carouselView = (CarouselView) v.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        final Button proSwipeBtn = (Button)v.findViewById(R.id.awesome_btn);

        proSwipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getFragmentManager().popBackStack();
                       getActivity().getFragmentManager().beginTransaction().addToBackStack(null);
                        getActivity().getFragmentManager().beginTransaction().replace(R.id.frame, new TabFragment()).commit();

            }
        });
//        proSwipeBtn.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
//            @Override
//            public void onSwipeConfirm() {
//                // user has swiped the btn. Perform your async operation now
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        // task success! show TICK icon in ProSwipeButton
//                        //proSwipeBtn.showResultIcon(true); // false if task failed
//                        getActivity().getFragmentManager().popBackStack();
//                        getActivity().getFragmentManager().beginTransaction().addToBackStack(null);
//                        getActivity().getFragmentManager().beginTransaction().replace(R.id.frame, new TabFragment()).commit();
//z
//                    }
//                }, 1000);
//            }
//        });


        return v;
    }

    public void gotoNext(View view){
                      getActivity().getFragmentManager().popBackStack();
                        getActivity().getFragmentManager().beginTransaction().addToBackStack(null);
                       getActivity().getFragmentManager().beginTransaction().replace(R.id.frame, new TabFragment()).commit();
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




