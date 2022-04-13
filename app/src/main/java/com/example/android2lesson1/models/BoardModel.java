package com.example.android2lesson1.models;



public class BoardModel {

    private String lottie;
    private String description;
    private String btnText;

    public BoardModel(String lottie, String description, String btnText) {
        this.lottie = lottie;
        this.description = description;
        this.btnText = btnText;
    }

    public String getLottie() {
        return lottie;
    }

    public String getDescription() {
        return description;
    }

    public String getBtnText() {
        return btnText;
    }
}
