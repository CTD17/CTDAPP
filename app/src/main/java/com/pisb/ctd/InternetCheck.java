package com.pisb.ctd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;


public class InternetCheck extends BroadcastReceiver {
    Intent i;

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        boolean nnotifypref = settings.getBoolean("notifications_new_message", true);
       // Toast.makeText(context, "Checking", Toast.LENGTH_SHORT).show();
        if (nnotifypref) {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
           // Toast.makeText(context, "Checking1", Toast.LENGTH_SHORT).show();
            NetworkInfo ni = cm.getActiveNetworkInfo();
          //  i = new Intent(context, Bservice.class);
            //context.startService(i);
            if (ni != null) {
                //

                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("service", 1);
                editor.commit();

               // context.startService(i);
            } else {

                if (settings.getInt("service", 0) == 1) {
              //      context.stopService(i);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("service", 0);
                    editor.commit();
                }
            //    context.stopService(i);
            }
        }
    }
}
