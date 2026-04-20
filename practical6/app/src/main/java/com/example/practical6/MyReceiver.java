package com.example.practical6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "Power Connected Broadcast Received",
                Toast.LENGTH_LONG).show();
    }
}