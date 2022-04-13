package com.example.android2lesson1.models;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.google.gson.JsonElement;

public class BoardModel {
    //private LottieAnimationView animationView;
   // private int image;
    private String lottie;
    private String description;
    private String btnText;

    public BoardModel(String lottie, String description, String btnText) {
        this.lottie = lottie;
        this.description = description;
        this.btnText = btnText;
    }

    public String getImage() {
        return lottie;
    }

    public String getDescription() {
        return description;
    }

    public String getBtnText() {
        return btnText;
    }
}
