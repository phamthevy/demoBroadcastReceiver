package com.kiten.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {
    private int status = -1;
    private int chargePlug = -1;
    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
