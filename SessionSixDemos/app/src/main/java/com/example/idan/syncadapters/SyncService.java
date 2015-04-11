package com.example.idan.syncadapters;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {

    private DemoSyncAdapter mSyncAdapter;

    public SyncService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSyncAdapter = new DemoSyncAdapter(getApplicationContext(), true);
    }

    @Override
    public IBinder onBind(Intent intent) {
      return mSyncAdapter.getSyncAdapterBinder();
    }
}
