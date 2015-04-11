package com.example.idan.siessionsixdemos.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by idan on 11/04/2015.
 */
public class ServiceLifetimeDemoService extends Service{

    private static final String TAG = "ServiceLifetimeDemoService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int res = super.onStartCommand(intent, flags, startId);
        Log.i(TAG, "onStartCommand()");
        return res;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        boolean ret = super.onUnbind(intent);
        Log.i(TAG, "onUnbind()");
        return ret;
    }
}
