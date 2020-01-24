package com.example.debarembar.controller;


import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.debarembar.R;

import org.json.JSONArray;

import java.util.ArrayList;

public class CompartilharLista extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static final String CHANNEL_ID = "BarNotificationChannel";
    NotificationCompat.Builder builder;
    ArrayList<String> bares = new ArrayList<>();
    private Button btnEnviarSms;
    private int notificationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissao();

        Intent in = getIntent();
        //final String numeroUser = in.getStringExtra("numeroUser");
        bares.add("Juka");
        bares.add("Gril do mato");
        bares.add("Chega são volta torto");

        JSONArray jsonArray = new JSONArray(bares);
        btnEnviarSms = findViewById(R.id.enviarSms);
        btnEnviarSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+5547996650611", null, jsonArray.toString(), null, null);

            }
        });
    }


    public void notification() {
        NotificationChannel channel;
        builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
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
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(notificationId, builder.build());
        } else {
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
            notificationManager.notify(notificationId, builder.build());
        }


    }

    public void permissao() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
    }
}