package com.example.idan.siessionsixdemos.services;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.idan.sessionsixdemos.R;

public class ServicesDemosActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_demos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_services_demos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startFiveToastsService(View view) {
        Intent i = new Intent(this, FiveToastsDemoIntentService.class);
        startService(i);

    }

    public void startTheService(View view) {
        Intent start = new Intent(this, ServiceLifetimeDemoService.class);
        startService(start);
    }

    public void stopTheService(View view) {
        Intent start = new Intent(this, ServiceLifetimeDemoService.class);
        stopService(start);
    }
}
