package com.example.admin.myapptest;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by admin on 2018/3/30.
 */

public class BaseService extends android.app.Service{

    private final String TAG = "BaseService";

    public class MyBinder extends Binder {
        public BaseService getServiceInstance() {
            return BaseService.this;
        }
    }

    private MyBinder mMyBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return mMyBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        return super.onUnbind(intent);

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(TAG, "onRebind");
    }

    public void function_1() {
        Log.i(TAG, "Base Service function_1 called");
        Framework.function_1();
    }

    public void function_2() {
        Log.i(TAG, "Base Service function_2 called");
        Framework.function_2();
    }
}
