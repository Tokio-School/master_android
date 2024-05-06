package com.example.retrofitfinal.hotel;

import com.google.gson.annotations.SerializedName;

public class HotelAddress {
    @SerializedName("streetAddress")
    private String streetAddess;
    @SerializedName("locality")
    private String locality;
    @SerializedName("postalCode")
    private int postalCode;
    @SerializedName("country")
    private String country;

    public HotelAddress() {
        //Empty Constructor
    }

    public String getStreetAddess() {
        return streetAddess;
    }

    public void setStreetAddess(String streetAddess) {
        this.streetAddess = streetAddess;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
