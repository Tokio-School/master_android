package com.example.retrofitfinal.hotel;

import com.google.gson.annotations.SerializedName;

public class ThumbUrl {
    @SerializedName("srpDesktop")
    private String srpDesktop;

    public ThumbUrl() {
        //Empty Constructor
    }

    public String getSrpDesktop() {
        return srpDesktop;
    }

    public void setSrpDesktop(String srpDesktop) {
        this.srpDesktop = srpDesktop;
    }
}
