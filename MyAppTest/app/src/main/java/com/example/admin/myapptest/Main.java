package com.example.admin.myapptest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by admin on 2018/3/25.
 */

public class Main extends Activity implements View.OnClickListener{

    private final String TAG = "Main";
    BaseService mBaseService = null;
    private TextView mTxt = null;

    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button1)).setOnClickListener(this);
        ((Button) findViewById(R.id.button2)).setOnClickListener(this);
        ((Button) findViewById(R.id.button3)).setOnClickListener(this);
        mTxt = (TextView) findViewById(R.id.sample_text);


    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BaseService.MyBinder binder = (BaseService.MyBinder) service;
            mBaseService = binder.getServiceInstance();
            Log.i(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected");
        }
    };

    public native static String stringFromJNI ();

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(Main.this, BaseService.class);
                bindService(intent, conn, BIND_AUTO_CREATE);
                break;
            case R.id.button2:

                if (mBaseService != null) {
                    mBaseService.function_1();
                } else {
                    Log.i(TAG, "mBaseService is null");
                }

                break;
            case R.id.button3:
                Intent i = new Intent(Main.this, Main2.class);
                startActivity(i);
            break;
        }
    }
}
