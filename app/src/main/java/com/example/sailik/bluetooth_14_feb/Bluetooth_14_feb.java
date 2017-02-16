package com.example.sailik.bluetooth_14_feb;

import android.app.Activity;
import android.app.Application;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * Created by saili.k on 15-02-2017.
 */

public class Bluetooth_14_feb extends Application implements Application.ActivityLifecycleCallbacks {
    public  boolean activityVisible;
    public  Activity mForegroundActivity;
    public int activityCount=0;

    StatusReciver appReceiver = new StatusReciver();

    public void setCurrentActivity(Activity ForegroundActivity){
        IntentFilter intfil = new IntentFilter();
        intfil.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        //temp=true;
        registerReceiver(appReceiver, intfil);
        this.mForegroundActivity = ForegroundActivity;
    }
    public Activity getCurrentActivity(){
        return this.mForegroundActivity;
    }

    public boolean isActivityVisible() {
        return this.activityVisible;
    }

    public void activityResumed() {
        activityVisible = true;

    }

    public void activityPaused() {
        activityVisible = false;
    }

    public int getActivityCount(){
        return activityCount;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//        IntentFilter intfil = new IntentFilter();
//        intfil.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
//        //temp=true;
//        registerReceiver(appReceiver, intfil);

        activityCount++;

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        activityCount--;
        if(activityCount==0){
            unregisterReceiver(appReceiver);
        }
    }
}
