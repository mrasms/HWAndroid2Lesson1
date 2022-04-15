package com.example.android2lesson1.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_model")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)

    private int id;
    private String title;
    private String regular;
    private String date;


    public TaskModel(String title, String regular, String date) {
        this.title = title;
        this.regular = regular;
        this.date = date;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRegular() {
        return regular;
    }

    public String getDate() {
        return date;
    }
}
