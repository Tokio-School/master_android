package com.example.retrofitfinal.hotel;

import com.google.gson.annotations.SerializedName;

public class RatePlan {
    @SerializedName("price")
    private Price price;

    public RatePlan() {
        //Empty Constructor
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
