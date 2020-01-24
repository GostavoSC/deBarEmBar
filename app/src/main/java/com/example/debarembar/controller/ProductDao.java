package com.example.debarembar.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.debarembar.model.Product;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product")
    List<Product> getAll();

    @Query("SELECT * FROM product WHERE id IN (:productIds)")
    List<Product> loadAllByIds(int[] productIds);

    @Insert
    void insertAll(ArrayList<Product> produtos);

    @Insert
    void insert(Product product);

    @Delete
    void delete(Product product);
}
