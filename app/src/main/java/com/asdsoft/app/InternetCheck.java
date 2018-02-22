package com.asdsoft.app;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InternetCheck extends BroadcastReceiver {
    Intent i;

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        boolean nnotifypref = settings.getBoolean("notifications_new_message",false);
        if (nnotifypref) {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo ni = cm.getActiveNetworkInfo();
            i = new Intent(context, Bservice.class);
            if (ni != null) {
                //
                // do here
                //


                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("service", 1);
                editor.commit();

              context.startService(i);
            } else {

                if (settings.getInt("service", 0) == 1) {
                    context.stopService(i);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("service", 0);
                    editor.commit();
                }
            }

        }

    else{
            if (settings.getInt("service", 0) == 1) {
                context.stopService(i);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("service", 0);
                editor.commit();
            }

    }
}
}
