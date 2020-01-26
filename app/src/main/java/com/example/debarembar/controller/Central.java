package com.example.debarembar.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.debarembar.MapsActivity;
import com.example.debarembar.R;

public class Central extends AppCompatActivity {

    Button btnCadastroBar, btnMinhaConta, btnListas, btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);


        btnCadastroBar.findViewById(R.id.btnCadastrarbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Central.this, CadastroBarActivity.class);
                startActivity(intent);
            }
        });

        btnListas.findViewById(R.id.btnLista).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnMinhaConta.findViewById(R.id.btnMinhaConta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Pegar segunda feira com gustavo D.
            }
        });
        btnMapa.findViewById(R.id.btnMaps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Central.this, MapsActivity.class);
                startActivity(intent);
            }
        });


    }
}
