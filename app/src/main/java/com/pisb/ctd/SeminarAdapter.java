package com.pisb.ctd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by drenu on 2/13/2018.
 */

public class SeminarAdapter extends BaseAdapter {

    String[] s;
    seminars semi;
    public SeminarAdapter(seminars semi,String[] s)
    {

        this.s=s;
        this.semi=semi;

    }

    @Override
    public int getCount() {

        return s.length;
    }

    @Override
    public Object getItem(int i) {
        return s[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_seminar,null);

        TextView t;
        t=(TextView) v.findViewById(R.id.tv1);
        t.setText(s[i]);



        return v;
    }
}
