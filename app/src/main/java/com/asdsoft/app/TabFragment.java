package com.asdsoft.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends android.app.Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;

    private FragmentActivity myContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v=inflater.inflate(R.layout.fragment_tab, container, false);




        viewPager = (ViewPager)v.findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(myContext.getSupportFragmentManager());
        adapter.addFrag(new ChildTabFragment(), "CTD");
        adapter.addFrag(new ChildTabFragment(), "PISB");
        adapter.addFrag(new ChildTabFragment(), "IEEE");
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout)v.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);




        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }



}
