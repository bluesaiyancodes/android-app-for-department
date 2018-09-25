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

public class attendance_sem4 extends Fragment {
    ImageView sub8;
    ImageView sub9;
    ImageView sub10;
    ImageView skill2;
    TextView attsub8;
    TextView attsub9;
    TextView attsub10;
    TextView attskill2;
    Boolean sub8spinned=false;
    Boolean sub9spinned=false;
    Boolean sub10spinned=false;
    Boolean skill2spinned=false;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        sub8=view.findViewById(R.id.sub8);
        sub9=view.findViewById(R.id.sub9);
        sub10=view.findViewById(R.id.sub10);
        skill2=view.findViewById(R.id.skill2);
        attsub8=view.findViewById(R.id.att_sub8);
        attsub9=view.findViewById(R.id.att_sub9);
        attsub10=view.findViewById(R.id.att_sub10);
        attskill2=view.findViewById(R.id.att_skill2);

        final Context context=getContext();
        final CachedInfo cachedInfo=new CachedInfo();

        sub8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub8);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub8);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub8spinned) {
                    attsub8.setText(cachedInfo.returnstudentattsub8());
                    sub8spinned=true;
                }
                else if(sub8spinned){
                    attsub8.setText("Discrete Structures");
                    sub8spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub8);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        sub9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub9);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub9);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub9spinned) {
                    attsub9.setText(cachedInfo.returnstudentattsub9());
                    sub9spinned=true;
                }
                else if(sub9spinned){
                    attsub9.setText("Computer Networking");
                    sub9spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub9);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        sub10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub10);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub10);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub10spinned) {
                    attsub10.setText(cachedInfo.returnstudentattsub10());
                    sub10spinned=true;
                }
                else if(sub10spinned){
                    attsub10.setText("Computer Graphics");
                    sub10spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub10);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(skill2);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attskill2);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!skill2spinned) {
                    attskill2.setText(cachedInfo.returnstudentattskill2());
                    skill2spinned=true;
                }
                else if(skill2spinned){
                    attskill2.setText("PhP");
                    skill2spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attskill2);
                anim3.setDuration(500);
                anim3.start();

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_sem4, container, false);

    }
}
