package com.example.idan.sessionsixdemos;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.idan.broadcasts.BroadcastsDemoActivity;
import com.example.idan.siessionsixdemos.services.ServicesDemosActivity;


public class MainActivity extends ActionBarActivity {

    private static final String AUTHORITY = "com.example.idan.sessionsixdemos.provider";
    private static final String ACCOUNT_TYPE = "com.example.idan.datasync";
    private static final String ACCOUNT = "demoAccount";

    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccount = createCustomAccount(this);

    }

    private static Account createCustomAccount(Context context) {
        Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
        AccountManager accountManager = (AccountManager) context.getSystemService(ACCOUNT_SERVICE);
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            Toast.makeText(context, "Account Created", Toast.LENGTH_LONG);
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }

        return newAccount;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void goToNotifications(View view) {
        goToActivity(NotificationsDemoActivity.class);
    }

    public void goToServices(View view) {
        goToActivity(ServicesDemosActivity.class);
    }

    public void goToBroadcasts(View view) {
        goToActivity(BroadcastsDemoActivity.class);
    }

    private void goToActivity(Class<?> target){
        Intent i = new Intent(this, target);
        startActivity(i);
    }

    public void doSync(View view) {
        Bundle settingsBundle = new Bundle();
        settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        ContentResolver.requestSync(mAccount, AUTHORITY, settingsBundle);
    }
}
