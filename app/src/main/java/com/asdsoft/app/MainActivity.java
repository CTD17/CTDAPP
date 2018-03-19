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
        implements NavigationView.OnNavigationItemSelectedListener
            {


    FragmentManager manager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager.popBackStack();
        manager.beginTransaction().addToBackStack(null);
        manager.beginTransaction().replace(R.id.frame, new Home()).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (savedInstanceState == null) {
               navigationView.getMenu().performIdentifierAction(R.id.nav_home, 0);
            navigationView.getMenu().getItem(0).setChecked(true);
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
                boolean nnotifypref = settings.getBoolean("notifications_new_message", true);
                jshedular(nnotifypref);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {

        Event event = (Event) getFragmentManager().findFragmentByTag("fragment_events");
        SigFragment sig = (SigFragment) getFragmentManager().findFragmentByTag("fragment_sig");
        seminars seminar = (seminars) getFragmentManager().findFragmentByTag("fragment_seminars");

        Home home = (Home) getFragmentManager().findFragmentByTag("home") ;

        //feedback fEEd = (feedback) getFragmentManager().findFragmentByTag("fragment_feedback");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        ContactUs contact = (ContactUs) getFragmentManager().findFragmentByTag("fragment_contact");
        if ((event != null && event.isVisible())  || ((sig != null && sig.isVisible()) || ((seminar != null && seminar.isVisible()) || ((contact != null && contact.isVisible()) || ((seminar != null && seminar.isVisible()) ))))) {
            getFragmentManager().beginTransaction().replace(R.id.frame, new Home()).commit();
        }
        else if ((home == null || !home.isVisible())){
            super.onBackPressed();
        }
        else {
            moveTaskToBack(true);
            //Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //onOptionsItemSelected(menu.getItem(R.id.nav_home));
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
        if (id == R.id.nav_home)
        {
            manager.popBackStack();
            manager.beginTransaction().addToBackStack("home");
            manager.beginTransaction().replace(R.id.frame, new Home()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            manager.popBackStack();
            manager.beginTransaction().addToBackStack("fragment_events");
            manager.beginTransaction().replace(R.id.frame, new Event(),"fragment_events").commit();


        } else if (id == R.id.nav_sig) {


            manager.popBackStack();
            manager.beginTransaction().addToBackStack("fragment_sig");
            //Toast.makeText(this,"Job Shedular Working ...", Toast.LENGTH_SHORT).show();
            manager.beginTransaction().replace(R.id.frame, new SigFragment(),"fragment_sig").commit();


        } else if (id == R.id.nav_seminar) {

            manager.popBackStack();
            manager.beginTransaction().addToBackStack("fragment_seminars");
            manager.beginTransaction().replace(R.id.frame, new seminars(),"fragment_seminars").commit();

        } else if (id == R.id.nav_share) {
            manager.popBackStack();
            manager.beginTransaction().addToBackStack("fragment_contact");
            manager.beginTransaction().replace(R.id.frame, new ContactUs(),"fragment_contact").commit();

        } else if (id == R.id.nav_send) {
            Intent share = new Intent("android.intent.action.SEND");
            share.setType("text/plain");
            share.putExtra("android.intent.extra.TEXT", getString(R.string.app_share) + "https://play.google.com/store/apps/details?id=com.pisb.ctd");
            startActivity(Intent.createChooser(share, "Share via"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void jshedular(boolean a) throws InterruptedException {
       // Toast.makeText(this,"Job Shedular  ...",Toast.LENGTH_LONG);
        ComponentName serviceComponent = new ComponentName(this, JService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
        builder.setPeriodic(100000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        JobScheduler jobScheduler = null;

        jobScheduler = (JobScheduler) this.getSystemService(JOB_SCHEDULER_SERVICE);

        if(a){

        int resultCode = jobScheduler.schedule(builder.build());
        String TAG = "hello";
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d(TAG, "Job scheduled!");
        } else {
            Log.d(TAG, "Job not scheduled");
        }}
        else{
        jobScheduler.cancelAll();
    }}
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void shedule(JobScheduler jobScheduler, JobInfo jobinfo){
        jobScheduler.schedule(jobinfo);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cancel(JobScheduler jobScheduler, JobInfo jobinfo){
     jobScheduler.cancelAll();
    }
}
