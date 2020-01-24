package com.example.debarembar.controller;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.debarembar.model.Bar;

import java.util.ArrayList;
import java.util.List;

public interface userDao {
    @Query("SELECT * FROM bar")
    List<Bar> getAll();

    @Query("SELECT * FROM bar WHERE id IN (:userIds)")
    List<Bar> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(ArrayList<Bar> bar);

    @Insert
    void insert(Bar bar);

    @Delete
    void delete(Bar bar);

    @Delete
    void deleteAll(ArrayList<Bar> bar);
}

