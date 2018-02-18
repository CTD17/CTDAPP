package com.asdsoft.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this,SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager manager = getFragmentManager();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            manager.popBackStack();
            manager.beginTransaction().addToBackStack(null);
            manager.beginTransaction().replace(R.id.frame, new events()).commit();


        } else if (id == R.id.nav_sig) {


            try {
                jshedular();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            manager.popBackStack();
            manager.beginTransaction().addToBackStack(null);
            manager.beginTransaction().replace(R.id.frame, new BlankFragment()).commit();


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void jshedular() throws InterruptedException {
        Toast.makeText(this,"Job Shedular  ...",Toast.LENGTH_LONG);
        ComponentName serviceComponent = new ComponentName(this, JService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        // builder.setMinimumLatency(1 * 1000); // wait at least
        // builder.setOverrideDeadline(3 * 1000); // maximum delay
       // builder.setPeriodic(10000);
       builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        JobScheduler jobScheduler = null;

            jobScheduler = (JobScheduler) this.getSystemService(JOB_SCHEDULER_SERVICE);

        int resultCode = jobScheduler.schedule(builder.build());
        String TAG = "hello";
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled!");
        } else {
            Log.d(TAG, "Job not scheduled");
        }
       // jobScheduler.cancelAll();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void shedule(JobScheduler jobScheduler, JobInfo jobinfo){
        jobScheduler.schedule(jobinfo);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cancel(JobScheduler jobScheduler, JobInfo jobinfo){
     jobScheduler.cancelAll();
    }
}
