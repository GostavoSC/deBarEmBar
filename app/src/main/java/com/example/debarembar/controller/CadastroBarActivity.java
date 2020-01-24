package com.example.debarembar.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.debarembar.R;
import com.example.debarembar.model.Banco;
import com.example.debarembar.model.Bar;

import com.example.debarembar.model.Product;

import java.util.ArrayList;

public class CadastroBarActivity extends AppCompatActivity {

    private ListView listViewProducts;
    private ArrayList<Product> listProducts;
    private ArrayAdapter<Product> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_bar);


        //listProducts.add();
        listProducts = new ArrayList<Product>();
        //Banco db = Banco.buildDatabase();
        //listProducts.add(db.productDao().getAll());

        listViewProducts= (ListView) findViewById(R.id.listView);
        arrayAdapter= new ArrayAdapter<Product> (this, android.R.layout.simple_list_item_1, listProducts);

        listViewProducts.setAdapter(arrayAdapter);







    }

}
