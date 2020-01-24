package com.example.debarembar.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Product {
    public Product(int ID, String name, float price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "price")
    public float price;

    public static ArrayList<Product> populateData() {
        ArrayList<Product> produtos = new ArrayList<Product>();
        Product skol = new Product(00, "Skol Lata 350ml", (float) 3.19);
        Product budweiser = new Product(01, "Budweiser Lata 350ml", (float) 3.99);
        Product original = new Product(02, "Original 600ml", (float) 7.99);
        Product stella = new Product(03, "Stella 275ml", (float) 3.99);
        Product amstel = new Product(04, "Amstel Lata 350ml", (float) 2.39);

        produtos.add(skol);
        produtos.add(budweiser);
        produtos.add(original);
        produtos.add(stella);
        produtos.add(amstel);

        return produtos;
    }

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

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
