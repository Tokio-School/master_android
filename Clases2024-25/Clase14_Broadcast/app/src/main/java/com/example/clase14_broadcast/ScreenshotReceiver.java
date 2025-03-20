package com.example.clase14_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.FileObserver;
import android.widget.Toast;

public class ScreenshotReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREENSHOT")) {
            Toast.makeText(context, "Captura de pantalla", Toast.LENGTH_SHORT).show();
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            FileObserver observer = new FileObserver(path) {
                @Override
                public void onEvent(int event, String path) {
                    if ((FileObserver.CREATE & event) != 0) {
                        Toast.makeText(context, "Archivo creado: " + path, Toast.LENGTH_SHORT).show();
                    }
                }
            };
            observer.startWatching();
        }
    }
}