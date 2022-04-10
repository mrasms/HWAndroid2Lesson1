package com.example.android2lesson1.models;

public class TaskModel {
    private String title;
    private String regular;
    private String date;

    public TaskModel(String title, String regular, String date) {
        this.title = title;
        this.regular = regular;
        this.date = date;
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
