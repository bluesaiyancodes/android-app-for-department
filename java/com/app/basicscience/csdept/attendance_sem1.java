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

import org.w3c.dom.Text;

/**
 * Created by bishalblue on 01/04/18.
 */

public class attendance_sem1 extends Fragment {
    ImageView sub1;
    ImageView sub2;
    TextView attsub1;
    TextView attsub2;
    Boolean sub1spinned=false;
    Boolean sub2spinned=false;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    sub1=view.findViewById(R.id.sub1);
    sub2=view.findViewById(R.id.sub2);
    attsub1=view.findViewById(R.id.att_sub1);
    attsub2=view.findViewById(R.id.att_sub2);
    final Context context=getContext();
    final CachedInfo cachedInfo=new CachedInfo();


    sub1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
            anim.setTarget(sub1);
            anim.setDuration(500);
            ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
            anim2.setTarget(attsub1);
            anim2.setDuration(500);
            anim.start();
            anim2.start();
            if(!sub1spinned) {
                attsub1.setText(cachedInfo.returnstudentattsub1());
                sub1spinned=true;
            }
            else if(sub1spinned){
                attsub1.setText("Programming in C");
                sub1spinned=false;
            }
            ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
            anim3.setTarget(attsub1);
            anim3.setDuration(500);
            anim3.start();

        }
    });

    sub2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
            anim.setTarget(sub2);
            anim.setDuration(500);
            ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
            anim2.setTarget(attsub2);
            anim2.setDuration(500);
            anim.start();
            anim2.start();
            if(!sub2spinned) {
                attsub2.setText(cachedInfo.returnstudentattsub2());
                sub2spinned=true;
            }
            else if(sub2spinned){
                attsub2.setText("DBMS");
                sub2spinned=false;
            }
            ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
            anim3.setTarget(attsub2);
            anim3.setDuration(500);
            anim3.start();

        }
    });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_sem1, container, false);

    }
}