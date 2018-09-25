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
 * Created by bishalblue on 05/03/18.
 */

public class SyllabusStudent extends Fragment {
    ImageView sem1;
    ImageView sem2;
    ImageView sem3;
    ImageView sem4;
    ImageView sem5;
    ImageView sem6;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Syllabus");
        sem1=view.findViewById(R.id.pic_sem1);
        sem2=view.findViewById(R.id.pic_sem2);
        sem3=view.findViewById(R.id.pic_sem3);
        sem4=view.findViewById(R.id.pic_sem4);
        sem5=view.findViewById(R.id.pic_sem5);
        sem6=view.findViewById(R.id.pic_sem6);

        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new syllabus_sem1();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();

            }
        });

        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new syllabus_sem2();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
            }
        });

        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new syllabus_sem3();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
            }
        });

        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new syllabus_sem4();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
            }
        });

        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new syllabus_sem5();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
            }
        });

        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new syllabus_sem6();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.content_student,fragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.select_sem,container,false);
        return view;
    }
}
