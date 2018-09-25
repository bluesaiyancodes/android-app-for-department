package com.app.basicscience.csdept;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by bishalblue on 05/04/18.
 */

public class MyFirebaseInsanceIdService extends FirebaseInstanceIdService {
    private static final String REG_TOKEN="REG_TOKEN";
    @Override
    public void onTokenRefresh() {
        String recent_token= FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_token);
    }
}
