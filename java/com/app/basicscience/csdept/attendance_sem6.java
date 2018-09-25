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

public class attendance_sem6 extends Fragment {

    ImageView sub13;
    ImageView sub14;
    ImageView dis3;
    TextView attsub13;
    TextView attsub14;
    TextView attdis3;
    Boolean sub13spinned=false;
    Boolean sub14spinned=false;
    Boolean dis3spinned=false;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        sub13=view.findViewById(R.id.sub13);
        sub14=view.findViewById(R.id.sub14);
        dis3=view.findViewById(R.id.sub_dis3);
        attsub13=view.findViewById(R.id.att_sub13);
        attsub14=view.findViewById(R.id.att_sub14);
        attdis3=view.findViewById(R.id.att_dis3);

        final Context context=getContext();
        final CachedInfo cachedInfo=new CachedInfo();

        sub13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub13);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub13);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub13spinned) {
                    attsub13.setText(cachedInfo.returnstudentattsub13());
                    sub13spinned=true;
                }
                else if(sub13spinned){
                    attsub13.setText("Artificial Intelligence");
                    sub13spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub13);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        sub14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub14);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub14);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub14spinned) {
                    attsub14.setText(cachedInfo.returnstudentattsub14());
                    sub14spinned=true;
                }
                else if(sub14spinned){
                    attsub14.setText("Design and Analysis of Algorithms");
                    sub14spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub14);
                anim3.setDuration(500);
                anim3.start();

            }
        });

        dis3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(dis3);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attdis3);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!dis3spinned) {
                    attdis3.setText(cachedInfo.returnstudentattdis3());
                    dis3spinned=true;
                }
                else if(dis3spinned){
                    attdis3.setText("Data Mining");
                    dis3spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attdis3);
                anim3.setDuration(500);
                anim3.start();

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_sem6, container, false);

    }
}
