package com.pisb.ctd;

//import android.ctd.FragmentManager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class Home extends android.app.Fragment implements View.OnClickListener {

    private FragmentActivity myContext;
    View v;
    int[] sampleImages = {R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3};
    CarouselView carouselView;
    Button btn1,btn2,btn3;

    public Home() {

    }
    //i updated home

    public  void  onBackPressed(){

        TabFragment tabFragment = (TabFragment) getFragmentManager().findFragmentByTag("Tab");
        DrawerLayout drawer = (DrawerLayout) v.findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        ContactUs contact = (ContactUs) getFragmentManager().findFragmentByTag("fragment_contact");
        if ((tabFragment != null && tabFragment.isVisible())) {
            getFragmentManager().beginTransaction().replace(R.id.frame, new Home()).commit();
        }

        else {
            //moveTaskToBack(true);
            //Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_home, container, false);

      //  btn1=(Button)v.findViewById(R.id.com);
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
                        getActivity().getFragmentManager().beginTransaction().addToBackStack("Tab");
                       getActivity().getFragmentManager().beginTransaction().replace(R.id.frame, new TabFragment(),"Tab").commit();
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




