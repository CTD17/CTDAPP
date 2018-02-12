package com.asdsoft.app;

import android.content.Context;
import android.net.Uri;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlankFragment extends android.app.Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    View myview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.sig,container,false);
        expListView = (ExpandableListView)myview.findViewById(R.id.expview);
        prepareListData();
        listAdapter = new ExpandableListAdapter(container.getContext(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        return myview;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("An Introduction to Machine Learning");
        listDataHeader.add("C++ coding");

        // Adding child data
        List<String> ml = new ArrayList<String>();
        ml.add("Introduction\n" +
                "Machine learning is a subfield of artificial intelligence (AI). The goal of machine learning generally is to understand the structure of data and fit that data into models that can be understood and utilized by people.");


        List<String> cpp = new ArrayList<String>();
        cpp.add("When we consider a C++ program, it can be defined as a collection of objects that communicate via invoking each other's methods. Let us now briefly look into what a class, object, methods, and instant variables mean.");



        listDataChild.put(listDataHeader.get(0), ml); // Header, Child data
        listDataChild.put(listDataHeader.get(1), cpp);
    }
}
