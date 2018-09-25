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

public class attendance_sem5 extends Fragment {

    ImageView sub11;
    ImageView sub12;
    ImageView dis1;
    ImageView dis2;
    TextView attsub11;
    TextView attsub12;
    TextView attdis1;
    TextView attdis2;
    Boolean sub11spinned=false;
    Boolean sub12spinned=false;
    Boolean dis1spinned=false;
    Boolean dis2spinned=false;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        sub11=view.findViewById(R.id.sub11);
        sub12=view.findViewById(R.id.sub12);
        dis1=view.findViewById(R.id.sub_dis1);
        dis2=view.findViewById(R.id.sub_dis2);
        attsub11=view.findViewById(R.id.att_sub11);
        attsub12=view.findViewById(R.id.att_sub12);
        attdis1=view.findViewById(R.id.att_dis1);
        attdis2=view.findViewById(R.id.att_dis2);

        final Context context=getContext();
        final CachedInfo cachedInfo=new CachedInfo();

        sub11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub11);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub11);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub11spinned) {
                    attsub11.setText(cachedInfo.returnstudentattsub11());
                    sub11spinned=true;
                }
                else if(sub11spinned){
                    attsub11.setText("Internet Technology");
                    sub11spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub11);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        sub12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub12);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub12);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub12spinned) {
                    attsub12.setText(cachedInfo.returnstudentattsub12());
                    sub12spinned=true;
                }
                else if(sub12spinned){
                    attsub12.setText("Software Engineering");
                    sub12spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub12);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        dis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(dis1);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attdis1);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!dis1spinned) {
                    attdis1.setText(cachedInfo.returnstudentattdis1());
                    dis1spinned=true;
                }
                else if(dis1spinned){
                    attdis1.setText("Machine Learning");
                    dis1spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attdis1);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        dis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(dis2);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attdis2);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!dis2spinned) {
                    attdis2.setText(cachedInfo.returnstudentattdis2());
                    dis2spinned=true;
                }
                else if(dis2spinned){
                    attdis2.setText("Microprocessor");
                    dis2spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attdis2);
                anim3.setDuration(500);
                anim3.start();

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_sem5, container, false);

    }
}
