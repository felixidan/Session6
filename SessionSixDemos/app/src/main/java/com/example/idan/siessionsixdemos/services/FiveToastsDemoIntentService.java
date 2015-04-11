package com.example.idan.siessionsixdemos.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

public class FiveToastsDemoIntentService extends IntentService {

    private static final String TAG = "FiveToastsDemoIntentService";
    private static final int ITERATIONS = 4;

    private int mMessageCounter;
    private Handler mHandler;

    public FiveToastsDemoIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mHandler = new Handler();
        mMessageCounter = 0;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mMessageCounter++;

        for (int i = 0; i < ITERATIONS; i++){
            String text = "Msg " + mMessageCounter + " - " + (i + 1);

            mHandler.post(new DisplayToast(text));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        String lastText = "Msg " + mMessageCounter + " - Done";
        mHandler.post(new DisplayToast(lastText));
    }

    private class DisplayToast implements Runnable{
        String mText;

        public DisplayToast(String text){
            mText = text;
        }

        public void run(){
            Toast.makeText(FiveToastsDemoIntentService.this, mText, Toast.LENGTH_SHORT).show();
        }
    }
}
