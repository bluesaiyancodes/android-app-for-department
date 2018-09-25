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

public class attendance_sem2 extends Fragment {
    ImageView sub3;
    ImageView sub4;
    TextView attsub3;
    TextView attsub4;
    Boolean sub3spinned=false;
    Boolean sub4spinned=false;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        sub3=view.findViewById(R.id.sub3);
        sub4=view.findViewById(R.id.sub4);
        attsub3=view.findViewById(R.id.att_sub3);
        attsub4=view.findViewById(R.id.att_sub4);
        final Context context=getContext();
        final CachedInfo cachedInfo=new CachedInfo();

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub3);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub3);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub3spinned) {
                    attsub3.setText(cachedInfo.returnstudentattsub3());
                    sub3spinned=true;
                }
                else if(sub3spinned){
                    attsub3.setText("Operating Systems");
                    sub3spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub3);
                anim3.setDuration(500);
                anim3.start();

            }
        });


        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flipping);
                anim.setTarget(sub4);
                anim.setDuration(500);
                ObjectAnimator anim2=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext);
                anim2.setTarget(attsub4);
                anim2.setDuration(500);
                anim.start();
                anim2.start();
                if(!sub4spinned) {
                    attsub4.setText(cachedInfo.returnstudentattsub4());
                    sub4spinned=true;
                }
                else if(sub4spinned){
                    attsub4.setText("Programming using C++");
                    sub4spinned=false;
                }
                ObjectAnimator anim3=(ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.flippingtext2);
                anim3.setTarget(attsub4);
                anim3.setDuration(500);
                anim3.start();

            }
        });
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_sem2, container, false);

    }
}
