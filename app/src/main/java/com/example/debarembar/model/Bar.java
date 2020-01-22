package com.example.debarembar.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.debarembar.controller.BarDao;

@Entity
public class Bar {
    public Bar(int ID, String name, String adress, int product) {
        this.ID = ID;
        this.name = name;
        this.adress = adress;
        this.product = product;
    }

    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "adress")
    public String adress;

    @ColumnInfo(name = "product")
    public int product;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getProduct() {
        return product;
    }
    public void setProduct(int product) {
        this.product = product;
    }
}
