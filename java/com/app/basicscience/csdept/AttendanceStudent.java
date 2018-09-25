package com.app.basicscience.csdept;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bishalblue on 05/03/18.
 */

public class AttendanceStudent extends Fragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CachedInfo cachedInfo=new CachedInfo();
        String name=cachedInfo.returnstudentname();
        getActivity().setTitle("Attendance - "+name);
        Fragment fragment=null;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        String semester=cachedInfo.returnsemester();
        switch(semester){
            case "1":
                fragment=new attendance_sem1();
                fragmentManager= getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
                break;
            case "2":
                fragment=new attendance_sem2();
                fragmentManager= getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
                break;
            case "3":
                fragment=new attendance_sem3();
                fragmentManager= getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
                break;
            case "4":
                fragment=new attendance_sem4();
                fragmentManager= getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
                break;
            case "5":
                fragment=new attendance_sem5();
                fragmentManager= getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
                break;
            case "6":
                fragment=new attendance_sem6();
                fragmentManager= getActivity().getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
                break;

        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_student,container,false);

    }
}
