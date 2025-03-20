package com.example.clase14_broadcast;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clase14_broadcast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private BatteryLowReceiver batteryLowReceiver;

    private NetworkChangeReceiver networkChangeReceiver;
    private PhoneStateReceiver phoneStateReceiver;


    private DescargaReceiver receiverFile ;

    private ScreenshotReceiver screenshotReceiver;

    // Definir las constantes para los códigos de solicitud
    private static final int REQUEST_CODE_PHONE_STATE = 1;
    private static final int REQUEST_CODE_CALL_LOG = 2;


    private static final int REQUEST_CODE_SMS= 3;

    private SmsReceiver smsReceiver;



    SoundModeReceiver soundModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Registrar el BroadcastReceiver dinámicamente de la bateria.
        batteryLowReceiver = new BatteryLowReceiver();
        IntentFilter filterBatery = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(batteryLowReceiver, filterBatery);

        // Registrar el BroadcastReceiver dinámicamente de la red.
        networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChangeReceiver, filter);


        // Registrar el BroadcastReceiver dinámicamente del estado del telefono.
        phoneStateReceiver = new PhoneStateReceiver();
        IntentFilter filterPhone = new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(phoneStateReceiver, filterPhone);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_CODE_PHONE_STATE);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, REQUEST_CODE_CALL_LOG);
        }


        // Registramos el broadcast para sms
        smsReceiver = new SmsReceiver();
        IntentFilter filterSMS = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(smsReceiver, filterSMS);

        // Verificar y solicitar permisos de SMS
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, REQUEST_CODE_SMS);
        }



        // Registrar el BroadcastReceiver dinámicamente
        soundModeReceiver = new SoundModeReceiver();
        IntentFilter filterSound = new IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION);
        registerReceiver(soundModeReceiver, filterSound);



        binding.bLanzarBroadcastPropio.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.clase14_broadcast.DESCARGA_COMPLETADA");
            intent.putExtra("archivo", "archivo.zip");
            intent.setPackage(getPackageName());

            sendBroadcast(intent);

        });

        receiverFile = new DescargaReceiver();
        IntentFilter filterFile = new IntentFilter("com.example.clase14_broadcast.DESCARGA_COMPLETADA");
        registerReceiver(receiverFile, filterFile, Context.RECEIVER_NOT_EXPORTED);


        screenshotReceiver = new ScreenshotReceiver();
        IntentFilter filterScreenshot = new IntentFilter("android.intent.action.SCREENSHOT");
        registerReceiver(screenshotReceiver, filterScreenshot,Context.RECEIVER_NOT_EXPORTED);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryLowReceiver);
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(phoneStateReceiver);
        unregisterReceiver(smsReceiver);
        unregisterReceiver(soundModeReceiver);
        unregisterReceiver(receiverFile);
        unregisterReceiver(screenshotReceiver);
    }


}