package com.example.idan.sessionsixdemos;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class NotificationsDemoActivity extends ActionBarActivity {

    private static final int SIMPLE_NOTIFICATION_ID = 1;
    private static final int EXTENDED_NOTIFICATION_ID = 2;
    private static final int CLICKABLE_NOTIFICATION_ID = 3;

    EditText titleET;
    EditText textET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_demo);

        titleET = (EditText) findViewById(R.id.notif_title);
        textET = (EditText) findViewById(R.id.notif_message);

        if (titleET.getText().toString().isEmpty()){
            titleET.setText("Lorem ipsum");
        }
        if (textET.getText().toString().isEmpty()){
            textET.setText("dolor sit amet");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notifications_demo, menu);
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

    public void notify(View view) {
        String title = titleET.getText().toString();
        String text = textET.getText().toString();
        int icon = R.drawable.ic_action_microphone;

        Notification n = new Notification.Builder(this)
                            .setContentTitle(title)
                            .setContentText(text)
                            .setSmallIcon(icon)
                            .build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        notificationManager.notify(SIMPLE_NOTIFICATION_ID, n);

    }

    public void notifyLorumIpsum(View view) {
        String title = "Lorem ipsum";
        String text = "dolor sit amet";
        int icon = R.drawable.ic_action_microphone;

        Notification.InboxStyle style = new Notification.InboxStyle();
        style.setBigContentTitle(title);
        style.addLine("Lorem ipsum dolor sit amet,");
        style.addLine("consectetur adipiscing elit.");
        style.addLine("ras ac urna lectus.");
        style.addLine("Aenean at urna eget nisl rutrum bibendum.");

        style.setSummaryText("Fusce tristique tortor ac lorem tempus scelerisque.");

        Notification n = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(icon)
                .setStyle(style)
                .build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(EXTENDED_NOTIFICATION_ID, n);
    }


    public void notifyClickableLorumIpsum(View view) {
        String title = "Lorem Ipsum";
        String text = "Click Me!";
        int icon = R.drawable.ic_action_microphone;

        Intent i = new Intent(this, LoremIpsumSpecialActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification n = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(icon)
                .setContentIntent(pi)
                .build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        notificationManager.notify(CLICKABLE_NOTIFICATION_ID, n);
    }
}
