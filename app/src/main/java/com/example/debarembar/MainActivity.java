package com.example.debarembar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.debarembar.model.Banco;
import com.example.debarembar.model.Product;

public class MainActivity extends AppCompatActivity {

    boolean iniciado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Banco db = Room.databaseBuilder(this,
                Banco.class, "DB").build();


    }


}
