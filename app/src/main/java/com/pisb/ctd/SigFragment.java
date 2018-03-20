package com.pisb.ctd;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SigFragment extends android.app.Fragment {


    List<String> listDataHeader;
    List<String> listDataChild;
    List<Integer> listImages;
    View myview;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        myview = inflater.inflate(R.layout.sig,container,false);
        final ListView listView=(ListView)myview.findViewById(R.id.listView);
        prepareListData();
       adapter a = new adapter();

        listView.setAdapter(a);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                TextView txtView = (TextView)view.findViewById(R.id.textview);
                if (txtView .getVisibility() == View.VISIBLE) {
                    txtView.setVisibility(View.GONE);
                    //txtView.setText("");
                }
                else {
                    txtView.setVisibility(View.VISIBLE);
                   // listView.smoothScrollToPosition(position);
                    if (position == listDataChild.size())
                        listView.smoothScrollToPosition(position);
                }
            }
        });
        return myview;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new ArrayList<String>();
        listImages=new ArrayList<>();
        //hello
        // Adding child data
        listDataHeader.add("Basics of programming");
        listDataHeader.add("Data structures using C/C++");
        listDataHeader.add("Shell scripting using Python");
        listDataHeader.add("Machine learning");

        listImages.add(R.drawable.sig1);
        listImages.add(R.drawable.cplus);
        listImages.add(R.drawable.py);
        listImages.add(R.drawable.brain);


        // Adding child data
       listDataChild.add("Basics of computer programming using C/C++ is explained.\nThe different kinds of algorithms are explored.Various problem solving methods and object oriented programming approaches are also seen.\n");
        listDataChild.add("Data structures are at the core of computer programming. These help in the effective organisation and handling of data.\nThe basic data structures are explored with the help of C/C++ in this SIG.");
        listDataChild.add("A shell script is a computer program designed to be run by the Unix shell, a command-line interpreter.The various dialects of shell scripts are considered to be scripting languages.\nIn this SIG Shell Scripting is explored with Python.");
        listDataChild.add("How does a machine make intelligent decisions?\nHow does a self driving car drive without human intervention?\nThe answer to these and many other questions is machine learning!\nIn this SIG an introduction of machine learning and its basic algorithms is given.");
    }

    class adapter extends BaseAdapter {
        private int mLastPosition;

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
            TextView txtView = (TextView)view.findViewById(R.id.textview);
            imageView.setImageResource(listImages.get(i));
            textView.setText(listDataHeader.get(i));
            txtView.setText(listDataChild.get(i));
            float initialTranslation = (mLastPosition <= i ? 500f : -500f);
            view.setTranslationY(initialTranslation);
            view.animate()
                    .setInterpolator(new DecelerateInterpolator(1.0f))
                    .translationY(0f)
                    .setDuration(300l)
                    .setListener(null);

            mLastPosition = i;

            return view;
        }
    }
}
