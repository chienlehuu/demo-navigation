package com.example.demonavigationdrawertoolbar.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.demonavigationdrawertoolbar.dao.KhoanThuDAO;
import com.example.demonavigationdrawertoolbar.model.KhoanThu;

@Database(entities = {KhoanThu.class}, version = 1)
public abstract class DatabaseManager extends RoomDatabase {
    public static final String DBNAME = "khoanthu.db";

    private static DatabaseManager instance;

    public static synchronized DatabaseManager getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DatabaseManager.class, DBNAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;

    }


    public abstract KhoanThuDAO khoanThuDAO();


}
