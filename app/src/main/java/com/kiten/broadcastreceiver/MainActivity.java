package com.kiten.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            if (status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL) {
                //is charging
                Toast.makeText(getApplicationContext(), "Đang sạc bin", Toast.LENGTH_SHORT).show();
            }

            //details of charging
            if (chargePlug == BatteryManager.BATTERY_PLUGGED_USB) {
                Toast.makeText(getApplicationContext(), "Đang sạc bin bằng USB", Toast.LENGTH_LONG).show();
                //charge USB
            } else if (chargePlug == BatteryManager.BATTERY_PLUGGED_AC) {
                Toast.makeText(getApplicationContext(), "Đang sạc bin bằng nguồn điện", Toast.LENGTH_LONG).show();
                //charge AC
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(mBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

}
