package com.example.sailik.bluetooth_14_feb;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;

/**
 * Created by saili.k on 14-02-2017.
 */



public class StatusReciver extends BroadcastReceiver {


    private static final int FAIL = -1;
    private static final String TAG=MainActivity.class.getName();
    
    ActivityManager am;
    ActivityManager.AppTask task;



    @Override
    public void onReceive(Context context, Intent intent) {
//        int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
//                -1);
//        Activity activity = Bluetooth_14_feb.GetCurrentActivity();
//        boolean appActive = Bluetooth_14_feb.isActivityVisible();
//        Bluetooth_14_feb obj = new Bluetooth_14_feb();
        Bluetooth_14_feb receiveObj = (Bluetooth_14_feb) context.getApplicationContext();
        boolean appActive = receiveObj.isActivityVisible();
        //int appActive = receiveObj.getActivityCount();
        //Log.d(TAG,"onReceive:receiver");
        String action = intent.getAction();            // Get intent's action string
        Bundle extras = intent.getExtras();

        if (extras == null) return;                    // All intents of interest have extras.


        switch (action) {
            case "android.bluetooth.adapter.action.STATE_CHANGED": {

                int state = extras.getInt("android.bluetooth.adapter.extra.STATE", FAIL);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF: 
                        if (!appActive) {

                                Toast.makeText(context,"Bluetooth:OFF",Toast.LENGTH_SHORT).show();

                        }
                        else{

                            Intent inten = new Intent(context,ConnectivityDialog.class);
                            inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(inten);
                            //num=1;

                        }

                        break;
                    
                    case BluetoothAdapter.STATE_ON:


                            if(!appActive) {
                                Log.d(TAG,"state-on-appactive");
                                Toast.makeText(context, "Bluetooth:ON", Toast.LENGTH_SHORT).show();
                            }
                            else{

                                Intent i = new Intent("FINISH");
                                //i.setAction("FINISH");
                                context.sendBroadcast(i);
                                Toast.makeText(context, "Bluetooth:ON", Toast.LENGTH_SHORT).show();
                            }



                        break;

                }

            }
        }
    }

}



