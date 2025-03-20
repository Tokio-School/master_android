package com.example.clase14_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("depurando", "onReceive del SmsReceiver");
        if (intent.getAction() != null && intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus != null) {
                    StringBuilder smsBody = new StringBuilder();
                    String sender = null;

                    for (Object pdu : pdus) {
                        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                        sender = smsMessage.getOriginatingAddress();
                        smsBody.append(smsMessage.getMessageBody());
                    }

                    // Mostrar el mensaje recibido
                    Toast.makeText(context, "SMS de " + sender + ": " + smsBody, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}