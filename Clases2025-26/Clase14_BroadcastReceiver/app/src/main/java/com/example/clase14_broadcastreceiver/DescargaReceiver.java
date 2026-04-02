package com.example.clase14_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DescargaReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.clase14_broadcastreceiver.DESCARGA_COMPLETADA")) {
            String nombre = intent.getStringExtra("nombre_archivo");
            Toast.makeText(context, "El archivo " + nombre + " ha sido descargado", Toast.LENGTH_SHORT).show();
        }

    }
}
