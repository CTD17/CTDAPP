package com.asdsoft.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class JService extends JobService {
    public JService() {
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this,"Job Shedular Working ...",Toast.LENGTH_SHORT).show();
        //SystemClock.sleep(10000);
//        try {
//            wait(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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
