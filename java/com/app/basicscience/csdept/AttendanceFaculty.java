package com.app.basicscience.csdept;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by bishalblue on 18/02/18.
 */

public class AttendanceFaculty extends Fragment {
    private static final String ATTENDANCE_URL="https://csdeptcbsh.000webhostapp.com/Attendance/selectsem.php";
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Manage Attendance");
        final WebView webView=view.findViewById(R.id.webview_attendance);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(ATTENDANCE_URL);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendance_all_sem,container,false);

    }

}
