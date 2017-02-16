package com.example.sailik.bluetooth_14_feb;

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

public class SeondActivity extends AppCompatActivity {

    private Button mNextButtonto3;
    private static final String TAG=SeondActivity.class.getName();
    private BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
    private Bluetooth_14_feb mAppObj;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seond);
        Log.d(TAG,"onCreate()");
        mAppObj = (Bluetooth_14_feb)getApplicationContext();
        mNextButtonto3= (Button) findViewById(R.id.button_toscreen3);

        if(BA.isEnabled()){

                Toast.makeText(this, "Bluetooth: ON", Toast.LENGTH_SHORT).show();


        }
        else{
            if(!BA.isEnabled()){

                    Intent i = new Intent(SeondActivity.this, ConnectivityDialog.class);
                    startActivity(i);

            }

        }



    }



    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume(){
        super.onResume();

        mAppObj.setCurrentActivity(this);
        mAppObj.activityResumed();

    }
    @Override
    protected void onPause(){
        super.onPause();

        mAppObj.activityPaused();
    }

    @Override
    protected void onStop(){

        super.onStop();


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();


    }

    public void onBClick(View v){
        Intent inten = new Intent(SeondActivity.this,ThirdActivity.class);
        this.startActivity(inten);
    }
}
