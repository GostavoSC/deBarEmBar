package com.example.debarembar.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.debarembar.controller.BarDao;
import com.example.debarembar.controller.ProductDao;

import java.util.concurrent.Executors;

@Database(entities = {Bar.class, Product.class}, version = 1 ,exportSchema = false)
public abstract class Banco extends RoomDatabase {
    public abstract BarDao barDao();
    public abstract ProductDao productDao();
    private static Banco INSTANCE;

    public synchronized static Banco getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    public static Banco buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                Banco.class,
                "my-database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).productDao().insertAll(Product.populateData());
                            }
                        });
                    }
                })
                .build();
    }


    //public abstract ProductDao productDao();



}
    