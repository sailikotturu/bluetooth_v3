package com.example.sailik.bluetooth_14_feb;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button mNextButtonto2;
    private static final String TAG=MainActivity.class.getName();
    private BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();

    public static boolean temp;
    private Bluetooth_14_feb mAppObj;
    //StatusReciver myb = new StatusReciver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate()");
        mAppObj = (Bluetooth_14_feb) getApplicationContext();

        mNextButtonto2= (Button) findViewById(R.id.mnhgf);

        if(BA.isEnabled()){

                Toast.makeText(this, "Bluetooth: ON", Toast.LENGTH_SHORT).show();


        }
        else{
            if(!BA.isEnabled()){

                    Intent i = new Intent(MainActivity.this, ConnectivityDialog.class);
                    startActivity(i);

            }

        }



    }




    public void onBclick(View v){
        Intent intent = new Intent(MainActivity.this, SeondActivity.class);
        this.startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
//        IntentFilter intfil = new IntentFilter();
//        intfil.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
//        temp=true;
//        registerReceiver(myb, intfil);

        Log.d(TAG,"registered mybroadcast");


    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume()");
        temp=true;
        mAppObj.setCurrentActivity(this);
        mAppObj.activityResumed();
    }

    @Override
    protected void onPause(){
        super.onPause();
        temp=false;
        mAppObj.activityPaused();
    }

    @Override
    protected void onStop(){
        temp = false;
        super.onStop();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //unregisterReceiver(mybroadcast);
        //unregisterReceiver(myb);

    }
}
