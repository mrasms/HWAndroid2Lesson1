package com.example.android2lesson1.model;

public class BoardModel {
    private int image;
    private String description;

    public BoardModel(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

}
