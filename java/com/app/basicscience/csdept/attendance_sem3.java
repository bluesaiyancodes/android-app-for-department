package com.app.basicscience.csdept;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bishalblue on 01/04/18.
 */

public class attendance_sem3 extends Fragment {
    ImageView sub5;
    ImageView sub6;
    ImageView sub7;
    ImageView skill1;
    TextView attsub5;
    TextView attsub6;
    TextView attsub7;
    TextView attskill1;
    Boolean sub5spinned=false;
    Boolean sub6spinned=false;
    Boolean sub7spinned=false;
    Boolean skill1spinned=false;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        sub5=view.findViewById(R.id.sub5);
        sub6=view.findViewById(R.id.sub6);
        sub7=view.findViewById(R.id.sub7);
        skill1=view.findViewById(R.id.skill1);
        attsub5=view.findViewById(R.id.att_sub5);
        attsub6=view.findViewById(R.id.att_sub6);
        attsub7=view.findViewById(R.id.att_sub7);
        attskill1=view.findViewById(R.id.att_skill1);

        final Context context=getContext();
        final CachedInfo cachedInfo=new CachedInfo();

        sub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub5);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub5);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub5spinned) {
                    attsub5.setText(cachedInfo.returnstudentattsub5());
                    sub5spinned=true;
                }
                else if(sub5spinned){
                    attsub5.setText("Data Structure");
                    sub5spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub5);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        sub6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub6);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub6);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub6spinned) {
                    attsub6.setText(cachedInfo.returnstudentattsub6());
                    sub6spinned=true;
                }
                else if(sub6spinned){
                    attsub6.setText("Computer Architecture");
                    sub6spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub6);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        sub7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub7);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub7);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub7spinned) {
                    attsub7.setText(cachedInfo.returnstudentattsub7());
                    sub7spinned=true;
                }
                else if(sub7spinned){
                    attsub7.setText("Java Programming");
                    sub7spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub7);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        skill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(skill1);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attskill1);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!skill1spinned) {
                    attskill1.setText(cachedInfo.returnstudentattskill1());
                    skill1spinned=true;
                }
                else if(skill1spinned){
                    attskill1.setText("HTML");
                    skill1spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attskill1);
                anim3.setDuration(500);
                anim3.start();

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_sem3, container, false);

    }
}
