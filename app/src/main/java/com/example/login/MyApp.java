package com.example.login;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {
    private static MyApp instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app-database")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}

