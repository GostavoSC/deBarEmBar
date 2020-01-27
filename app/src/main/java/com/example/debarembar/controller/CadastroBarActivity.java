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
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CadastroBarActivity extends AppCompatActivity {
    int n = 4;

    private ListView listViewProducts;
    private ArrayList<Product> listProducts = new ArrayList<Product>();
    private ArrayAdapter<Product> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_bar);
        Banco bd = Banco.getInstance(getApplicationContext());



        arrayAdapter= new ArrayAdapter<Product> (this, android.R.layout.simple_list_item_1, listProducts);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int[] a = criaVetor(n);

                List<Product> minhaMae = bd.productDao().loadAllByIds(a);

                listProducts.addAll(minhaMae);
                listViewProducts= (ListView) findViewById(R.id.listView);
                listViewProducts.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });



    }

    public int[] criaVetor(int n){

        int  listaP[] = new int[n];

        for (int i = 0; i <4; i++){
            listaP[i] = i;
        }
        return listaP;
    }

}
