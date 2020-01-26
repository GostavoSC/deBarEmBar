package com.example.debarembar.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.debarembar.Contatos;
import com.example.debarembar.MapsActivity;
import com.example.debarembar.R;

public class Central extends AppCompatActivity {

    Button btnCadastroBar, btnMinhaConta, btnListas, btnMapa,btnCompartilharLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);

        btnCompartilharLista=findViewById(R.id.btnCompartilhar);
        btnCompartilharLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Contatos.class);
                startActivity(intent);
            }
        });


        btnCadastroBar=findViewById(R.id.btnCadastrarbar);
        btnCadastroBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Central.this, CadastroBarActivity.class);
                startActivity(intent);
            }
        });


        btnListas=findViewById(R.id.btnLista);
        btnListas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnMinhaConta=findViewById(R.id.btnMinhaConta);
        btnMinhaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Pegar segunda feira com gustavo D.
            }
        });
        btnMapa = findViewById(R.id.btnMaps);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Central.this, MapsActivity.class);
                startActivity(intent);
            }
        });


    }
}
