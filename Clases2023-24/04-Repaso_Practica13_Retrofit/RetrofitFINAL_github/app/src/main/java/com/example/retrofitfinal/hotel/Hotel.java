package com.example.retrofitfinal.hotel;

import com.google.gson.annotations.SerializedName;

public class Hotel {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("starRating")
    private int starRating;
    @SerializedName("address")
    private HotelAddress hotelAddress;

    public RatePlan getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(RatePlan ratePlan) {
        this.ratePlan = ratePlan;
    }

    @SerializedName("ratePlan")
    private RatePlan ratePlan;
    @SerializedName("neighbourhood")
    private String neighbourhood;

    public ThumbUrl getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(ThumbUrl thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @SerializedName("optimizedThumbUrls")
    private ThumbUrl thumbUrl;

    public Hotel() {
        //Empty Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public HotelAddress getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(HotelAddress hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }
}
