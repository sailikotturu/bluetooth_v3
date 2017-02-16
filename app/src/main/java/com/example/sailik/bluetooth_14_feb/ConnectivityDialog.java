package com.example.sailik.bluetooth_14_feb;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ConnectivityDialog extends AppCompatActivity implements View.OnClickListener {
    private Button mOK;
    public  String str = "closedialog";
    private Bluetooth_14_feb mAppObj;

    private static final String TAG=SeondActivity.class.getName();
//    BluetoothAdapter mBA = BluetoothAdapter.getDefaultAdapter();
//
//    if(!mBA.isEnabled()){
//
//    }
//    else{
//        finish();
////    }
    BroadcastReceiver newbroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


           Log.d(TAG,"newbroadcast--finish--dialogclass");
           finish();

        }
    };



//    @Override
//    protected void onNewIntent(Intent intent) {
//        //super.onNewIntent(intent);
//        Log.d(TAG,"onnewintent");
//        if (str.equals(intent.getAction())){
//            finish();
//            onDestroy();
//        }
//        else{
//            setContentView(R.layout.activity_connectivity_dialog);
//        }
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
//            Intent i = getIntent();
//            onNewIntent(i);
            setContentView(R.layout.activity_connectivity_dialog);
            Log.d(TAG,"oncreate-dialog");
            mAppObj = (Bluetooth_14_feb) getApplicationContext();
            mOK = (Button) findViewById(R.id.button_ok);

            mOK.setOnClickListener(ConnectivityDialog.this);


    }
    @Override
    protected void onStart(){

        super.onStart();
        registerReceiver(newbroadcast, new IntentFilter("FINISH"));

    }

    @Override
    public void onClick(View v) { // Parameter v stands for the view that was clicked.

        switch (v.getId()) {
            case R.id.button_ok:

                finish();

                break;

        }
    }

    @Override
    protected void onResume(){
        super.onResume();
//        registerReceiver(newbroadcast, new IntentFilter("FINISH"));
        //Toast.makeText(this,"registered--connectivitydialog",Toast.LENGTH_SHORT).show();
        mAppObj.setCurrentActivity(this);
        mAppObj.activityResumed();
    }
    @Override
    protected void onPause(){
        super.onPause();
        mAppObj.activityPaused();
        unregisterReceiver(newbroadcast);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //unregisterReceiver(newbroad);

    }
}