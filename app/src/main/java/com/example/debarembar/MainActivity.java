package com.example.debarembar;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;


import com.example.debarembar.controller.Broadcast;

import androidx.room.Room;



import com.example.debarembar.model.Banco;


public class MainActivity extends AppCompatActivity {

    boolean iniciado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Broadcast broadcast = new Broadcast();

        Banco db = Room.databaseBuilder(this,
                Banco.class, "DB").build();



    }


}
