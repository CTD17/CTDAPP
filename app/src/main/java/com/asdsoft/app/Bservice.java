package com.asdsoft.app;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.graphics.Color.RED;

/**
 * Created by LENOVO on 17-02-2018.
 */

public class Bservice extends IntentService {
//    Context context = getApplicationContext();
    public Bservice() {
        super("BackGround");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while (true){
            getvalues(getApplicationContext(),intent);
            SystemClock.sleep(5000);
            //Toast.makeText(getApplicationContext(), "you got it", Toast.LENGTH_LONG).show();

          //  Log.v("internetcheck:","You got It" );
        }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    public void getvalues(final Context context, final Intent intent) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Notify>> call = api.getevent();

        call.enqueue(new Callback<List<Notify>>() {
            @Override
            public void onResponse(Call<List<Notify>> call, Response<List<Notify>> response) {
                List<Notify> eventlist = response.body();

                //Creating an String array for the ListView


                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < eventlist.size(); i++) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    // Toast.makeText(context, eventlist.get(i).getCode().toString(), Toast.LENGTH_LONG).show();
                    if(eventlist.get(i).getCode() != sharedPreferences.getInt("key", 0)) {

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("key", eventlist.get(i).getCode());
                        editor.commit();
                        notifiaction(eventlist.get(i).getEvent(), eventlist.get(i).getInfo(), context, intent);
                    }
                }


                //displaying the string array into listview


            }

            @Override
            public void onFailure(Call<List<Notify>> call, Throwable t) {
                //Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void notifiaction(String event,String info,Context context,Intent intent) {
        Intent intent1 = new Intent(getApplicationContext(),SplashScreen.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(context);
        int color = getResources().getColor(R.color.colorPrimary);

        b.setAutoCancel(true)
                .setContentTitle(event)
                .setSmallIcon(R.drawable.unravel1)
                .setContentText(info)
                .setColor(color)
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentIntent(contentIntent);



        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, b.build());
    }



}
