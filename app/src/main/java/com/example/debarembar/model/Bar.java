package com.example.debarembar.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Bar {
    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "NULL NAME")
    public String name;

    @ColumnInfo(name = "NULL ADRESS")
    public String adress;

    @ColumnInfo(name = "NULL PRODUCT")
    public int products;


}
