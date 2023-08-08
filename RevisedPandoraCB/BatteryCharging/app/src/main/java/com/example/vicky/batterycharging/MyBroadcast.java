package com.example.vicky.batterycharging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            context.startActivity(new Intent(context,MainActivity.class));
        }
        else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        Toast.makeText(context,"Power is connected",Toast.LENGTH_SHORT).show();
    }
}
