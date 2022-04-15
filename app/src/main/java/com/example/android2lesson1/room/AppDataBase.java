package com.example.android2lesson1.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android2lesson1.models.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
