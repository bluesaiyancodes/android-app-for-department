package com.app.basicscience.csdept;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by bishalblue on 03/04/18.
 */

public class faculty_studinfo extends Fragment {

    private static final String STUDINFO_URL="https://csdeptcbsh.000webhostapp.com/getinfo/selectsem.php";
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("View Student Information");
        final WebView webView=view.findViewById(R.id.webview_attendance);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(STUDINFO_URL);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.stud_info,container,false);

    }
}
