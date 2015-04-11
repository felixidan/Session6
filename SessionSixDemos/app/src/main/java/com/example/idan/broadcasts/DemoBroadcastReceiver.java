package com.example.idan.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by idan on 11/04/2015.
 */
public class DemoBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Got a " + intent.getAction(), Toast.LENGTH_LONG).show();
    }

}
