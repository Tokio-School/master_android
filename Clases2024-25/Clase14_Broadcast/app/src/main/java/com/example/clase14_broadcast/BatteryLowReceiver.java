package com.example.clase14_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryLowReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        switch (action){
            case Intent.ACTION_BATTERY_LOW:
                Toast.makeText(context, "Batería baja", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_BATTERY_OKAY:
                Toast.makeText(context, "Batería okay", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Cargando", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Desconectado de la carga", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
