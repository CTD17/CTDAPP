package com.asdsoft.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ChildTabFragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
String info="PISB was established in the year 1998 with the aim of inculcating the sense of technical awareness amongst its student members. PISB endeavers to escalate the knowledge and trends in the diverse field of technologies amongst its members. PISB upholds two major events every year, Credenz and Credenz Tech Dayz with the first one being conducted in the even semester and the second one in the odd semester. PISB is also marked by its Women in Engineering(WIE) chapter, an initiative for impowerment of women in the technical domain.\n";

        return inflater.inflate(R.layout.fragment_child_tab_fragment1, container, false);
    }

}
