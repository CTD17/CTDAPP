package com.asdsoft.app;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class events extends android.app.Fragment {


    public events() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //SharedPreferences setting =  getSharedPreferences("Setting", Context.MODE_PRIVATE);
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

}
