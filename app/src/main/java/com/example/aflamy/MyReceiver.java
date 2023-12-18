package com.example.aflamy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {
            Toast.makeText(context, "Battery LOW", Toast.LENGTH_SHORT).show();
    }
}}
