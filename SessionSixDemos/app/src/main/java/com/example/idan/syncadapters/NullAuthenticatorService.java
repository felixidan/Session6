package com.example.idan.syncadapters;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NullAuthenticatorService extends Service {

    private NullAuthenticator mAuthenticator;

    @Override
    public void onCreate() {
        super.onCreate();

        mAuthenticator = new NullAuthenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
