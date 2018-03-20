package com.pisb.ctd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ChildTabFragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String info="The Institute of Electrical and Electronics Engineering (IEEE) is an international organization, which has been the nexus for propagating scientific expertise among people all over the globe. IEEE continues to attract students, faculty and professionals from various fields all around the world and is committed to incorporate diversity in thoughts which is essential for scientific development. IEEE serves as a hub to many engineering students and faculty members for expressing their technical acuity to the world and has always been at the forefront of the technical revolution.";



        return inflater.inflate(R.layout.fragment_child_tab_fragment2, container, false);
    }
}
