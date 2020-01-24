package com.example.debarembar.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.debarembar.controller.BarDao;
import com.example.debarembar.controller.ProductDao;

@Database(entities = {Bar.class, Product.class}, version = 1)

public abstract class Banco extends RoomDatabase {
    public abstract BarDao barDao();
    public abstract ProductDao productDao();

    //public abstract ProductDao productDao();



}
    