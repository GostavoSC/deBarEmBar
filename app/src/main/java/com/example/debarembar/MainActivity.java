package com.example.debarembar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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