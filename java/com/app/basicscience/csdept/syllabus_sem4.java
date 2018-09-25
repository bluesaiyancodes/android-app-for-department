package com.app.basicscience.csdept;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by bishalblue on 10/03/18.
 */

public class syllabus_sem4 extends Fragment {
    private static final String SYLLABUS_SEM1="https://csdeptcbsh.000webhostapp.com/SemesterSyllabus/FourthSemester.pdf";
    private static final String GOOGLE_VIEW="http://drive.google.com/viewerng/viewer?embedded=true&url=";
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Semester 4 - Syllabus");
        final WebView webView=view.findViewById(R.id.webview_sylb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(GOOGLE_VIEW+SYLLABUS_SEM1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.syllabus_all_sem,container,false);

    }
}
