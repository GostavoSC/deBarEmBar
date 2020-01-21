package com.example.debarembar.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface BarDao {
    @Dao
    public interface UserDao {
        @Query("SELECT * FROM user")
        List<Bar> getAll();

        @Query("SELECT * FROM bar WHERE id IN (:userIds)")
        List<Bar> loadAllByIds(int[] userIds);

        @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1")
        User findByName(String first, String last);

        @Insert
        void insertAll(User... users);

        @Delete
        void delete(User user);
    }

}
