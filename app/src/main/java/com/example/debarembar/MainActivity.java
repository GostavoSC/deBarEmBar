package com.example.debarembar;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.IntentFilter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.debarembar.controller.Broadcast;

import androidx.room.Room;



import com.example.debarembar.model.Banco;


public class MainActivity extends AppCompatActivity {


    boolean iniciado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        Banco db = Room.databaseBuilder(this,
                Banco.class, "DB").build();


        Button btnOpen = findViewById(R.id.openMap);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "• Iniciando mapa •", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

    }


}






