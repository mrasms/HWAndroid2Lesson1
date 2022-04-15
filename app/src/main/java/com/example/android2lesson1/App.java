package com.example.android2lesson1;

import android.app.Application;

import androidx.room.Room;

import com.example.android2lesson1.room.AppDataBase;

public class App extends Application {

    private AppDataBase dataBase;
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        dataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "database").allowMainThreadQueries().build();
    }

    public AppDataBase getDataBase() {
        return dataBase;
    }

    public static App getApp() {
        return app;
    }
}
