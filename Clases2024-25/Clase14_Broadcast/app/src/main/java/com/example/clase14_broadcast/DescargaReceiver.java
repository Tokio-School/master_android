package com.example.clase14_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DescargaReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.clase14_broadcast.DESCARGA_COMPLETADA")) {
            String nombreArchivo = intent.getStringExtra("archivo");
            Toast.makeText(context, "Descarga completada: " + nombreArchivo, Toast.LENGTH_SHORT).show();
        }
    }
}
