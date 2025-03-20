package com.example.clase14_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import android.widget.Toast;

public class SoundModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Verificar si la acción es el cambio en el modo de sonido
        if (AudioManager.RINGER_MODE_CHANGED_ACTION.equals(intent.getAction())) {
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            int ringerMode = audioManager.getRingerMode();

            // Verificar el modo de sonido actual
            switch (ringerMode) {
                case AudioManager.RINGER_MODE_NORMAL:
                    Toast.makeText(context, "Modo normal activado", Toast.LENGTH_SHORT).show();
                    Log.d("depurando", "Modo normal activado");
                    break;
                case AudioManager.RINGER_MODE_SILENT:
                    Toast.makeText(context, "Modo silencioso activado", Toast.LENGTH_SHORT).show();
                    Log.d("depurando", "Modo silencioso activado");
                    break;
                case AudioManager.RINGER_MODE_VIBRATE:
                    Toast.makeText(context, "Modo vibrar activado", Toast.LENGTH_SHORT).show();
                    Log.d("depurando", "Modo vibrar activado");
                    break;
            }
        }
    }
}