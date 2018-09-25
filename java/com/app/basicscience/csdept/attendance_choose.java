package com.app.basicscience.csdept;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by bishalblue on 04/04/18.
 */

public class attendance_choose extends Fragment {
    ImageView att_choose1;
    ImageView att_choose2;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Manage Attendance");
        att_choose1=view.findViewById(R.id.att_choose1);
        att_choose2=view.findViewById(R.id.att_choose2);

        att_choose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new AttendanceFaculty();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_faculty,fragment);
                fragmentTransaction.commit();
            }
        });

        att_choose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new attendance_all_sem();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_faculty,fragment);
                fragmentTransaction.commit();
            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_choose,container,false);

    }
}
