package com.asdsoft.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SigFragment extends android.app.Fragment {


    List<String> listDataHeader;
    List<String> listDataChild;
    View myview;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        myview = inflater.inflate(R.layout.sig,container,false);
        ListView listView=(ListView)myview.findViewById(R.id.listView);
        prepareListData();
       adapter a = new adapter();

        listView.setAdapter(a);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                TextView txtView = (TextView)view.findViewById(R.id.textview);

                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                if (txtView .getVisibility() == View.VISIBLE) {
                    txtView.setVisibility(View.GONE);
                    txtView.setText("");
                    // txtView.setHeight(0);
                }
                else {
                    txtView.setVisibility(View.VISIBLE);
                    txtView.setText(listDataChild.get(position));
                    // txtView.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

                }
            }
        });
        return myview;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new ArrayList<String>();
        //hello
        // Adding child data
        listDataHeader.add("An Introduction to Machine Learning");
        listDataHeader.add("An Introduction to C++ coding");
        listDataHeader.add("An Introduction to C coding");
        listDataHeader.add("An Introduction to python coding");

        // Adding child data
        listDataChild.add("Introduction\n" +
                "Machine learning is a subfield of artificial intelligence (AI). The goal of machine learning generally is to understand the structure of data and fit that data into models that can be understood and utilized by people.");
        listDataChild.add("When we consider a C++ program, it can be defined as a collection of objects that communicate via invoking each other's methods. Let us now briefly look into what a class, object, methods, and instant variables mean.");
        listDataChild.add("When we consider a C++ program, it can be defined as a collection of objects that communicate via invoking each other's methods. Let us now briefly look into what a class, object, methods, and instant variables mean.");
        listDataChild.add("When we consider a C++ program, it can be defined as a collection of objects that communicate via invoking each other's methods. Let us now briefly look into what a class, object, methods, and instant variables mean.");

    }

    class adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listDataHeader.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                LayoutInflater infalInflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_group,null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView)view.findViewById(R.id.lblListHeader);
            if(i%2 == 0)
                imageView.setImageResource(R.drawable.cpp);
            else
                imageView.setImageResource(R.drawable.blue);
            textView.setText(listDataHeader.get(i));

            return view;
        }
    }
}
