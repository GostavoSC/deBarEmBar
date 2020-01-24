package com.example.debarembar.controller;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.debarembar.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifAnimationMetaData;

public class CompartilharLista extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1 ;
    private Button btnEnviarSms;
    private ImageView imgLoading;
    ArrayList <String>bares =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissao();
        Intent in= getIntent();
        final String numeroUser = in.getStringExtra("numeroUser");


        bares.add("Juka");
        bares.add("Gril do mato");
        bares.add("Chega são volta torto");




        btnEnviarSms = findViewById(R.id.enviarSms);

        btnEnviarSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toString = "MELHORES BARES";
                toString +="\n";

                for(int i = 0; i< bares.size();i++) {
                    toString += bares.get(i) + "\n";
                }
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(numeroUser, null, toString, null, null);

                }


        });

    }
    public void permissao(){
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