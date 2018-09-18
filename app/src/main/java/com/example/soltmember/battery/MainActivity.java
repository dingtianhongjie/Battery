package com.example.soltmember.battery;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private StringBuilder sbuilder = new StringBuilder();
    private Intent batteryStatus;
    private BatteryManager bManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryStatus = this.registerReceiver(null, ifilter);

        if(batteryStatus != null){
            baInfo();
        }
        TextView textView = findViewById(R.id.textBattery);
        textView.setText(sbuilder);


    }

    private void baInfo() {
        int level = batteryStatus.getIntExtra(
                BatteryManager.EXTRA_LEVEL, -1);
        sbuilder.append("Level: ");
        sbuilder.append(String.valueOf(level));
    }

}
