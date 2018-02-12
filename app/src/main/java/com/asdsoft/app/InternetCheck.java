package com.asdsoft.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by LENOVO on 12-02-2018.
 */

public class InternetCheck extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent)
    {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService (Context.CONNECTIVITY_SERVICE);

        NetworkInfo ni = cm.getActiveNetworkInfo();
        if(ni != null){
        Toast.makeText(context, "you got it", Toast.LENGTH_LONG).show();
        // do here
       }

    }
}
