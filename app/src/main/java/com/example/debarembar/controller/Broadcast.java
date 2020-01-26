package com.example.debarembar.controller;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;





import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.debarembar.R;

import org.json.JSONArray;

import java.util.ArrayList;

public class Broadcast extends BroadcastReceiver {


    private static final String CHANNEL_ID = "BarNotificationChannel";
    private int notificationId = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            Object[] pdus = (Object[]) bundle.get("pdus");

            if (bundle != null) {

                for (int i = 0; i < pdus.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    Log.e("wsasasa", message);


                    JSONArray jsonArray = new JSONArray(message);
                    ArrayList<String> baresIdos = new ArrayList<>();
                    for (int j = 0; j < jsonArray.length(); j++) {
                        baresIdos.add(String.valueOf(jsonArray.get(j)));
                    }


                    NotificationChannel channel;
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                            .setSmallIcon(R.drawable.icon)
                            .setContentTitle("UUUBAAA, OLHA A LISTA DE BAR CONSAGRADO")
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText("Te enviaram uma nova lista meu amigo, da uma olhadinha"))
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        CharSequence name = "De Bar em bar";
                        String description = "teste";
                        int importance = NotificationManager.IMPORTANCE_DEFAULT;
                        channel = new NotificationChannel(CHANNEL_ID, name, importance);
                        channel.setDescription(description);
                        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
                        notificationManager.createNotificationChannel(channel);
                        notificationManager.notify(notificationId, builder.build());
                    } else {
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
                        notificationManager.notify(notificationId, builder.build());
                    }


                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }

    }
    public void notification() {

    }
}