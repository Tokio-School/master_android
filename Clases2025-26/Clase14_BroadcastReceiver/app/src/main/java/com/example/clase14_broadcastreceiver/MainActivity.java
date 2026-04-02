package com.example.clase14_broadcastreceiver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase14_broadcastreceiver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    BatteryLowReceiver recibirBateria;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        /** Broadcast de descarga de fichero */

        binding.bLanzarBroadcast.setOnClickListener(view -> {
            Intent intent = new Intent("com.example.clase14_broadcastreceiver.DESCARGA_COMPLETADA");
            intent.putExtra("nombre_archivo", "archivo_descargado.pdf");
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
        });

      /*  DescargaReceiver recibirNofitificacionFichero= new DescargaReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.clase14_broadcastreceiver.DESCARGA_COMPLETADA");
        registerReceiver(recibirNofitificacionFichero, intentFilter);*/


        /** Broads para la bateria */
        recibirBateria= new BatteryLowReceiver();
        IntentFilter filterBateria = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(recibirBateria, filterBateria);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(recibirBateria);

    }
}