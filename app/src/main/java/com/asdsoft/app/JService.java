package com.asdsoft.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JService extends JobService {
    public JService() {
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
       // Toast.makeText(this,"Job Shedular Working ...",Toast.LENGTH_SHORT).show();
        //SystemClock.sleep(10000);
//        try {
//            wait(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Intent intent = new Intent(this, MainActivity.class);
        new Athread(this,intent).execute();
        String TAG = "hello";
        Log.d(TAG, "Job in ..!");
       jobFinished(jobParameters,true);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

