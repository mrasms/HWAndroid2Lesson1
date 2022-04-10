package com.example.android2lesson1.models;

public class BoardModel {
    private int image;
    private String description;
    private String btnText;

    public BoardModel(int image, String description, String btnText) {
        this.image = image;
        this.description = description;
        this.btnText = btnText;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getBtnText() {
        return btnText;
    }
}
