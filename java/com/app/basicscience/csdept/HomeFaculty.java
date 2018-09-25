package com.app.basicscience.csdept;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bishalblue on 18/02/18.
 */

public class HomeFaculty extends Fragment {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CachedInfo cachedInfo=new CachedInfo();
        String name=cachedInfo.returnfacultyname();
        getActivity().setTitle("Home - "+name);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_faculty,container,false);

    }
}
