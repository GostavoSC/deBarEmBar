package com.example.debarembar.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.debarembar.R;
import com.example.debarembar.model.Banco;
import com.example.debarembar.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MostraListaBar extends AppCompatActivity {
    private ListView listViewProducts;
    private ArrayList<Product> listProducts = new ArrayList<Product>();
    private ArrayAdapter<Product> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_lista_bar);

        Banco bd = Banco.getInstance(getApplicationContext());


        listViewProducts= (ListView) findViewById(R.id.listView);
        listViewProducts.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

    }
}
