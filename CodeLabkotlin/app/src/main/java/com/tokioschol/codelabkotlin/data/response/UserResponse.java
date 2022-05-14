package com.tokioschol.codelabkotlin.data.response;

public class UserResponse {

    private String nameResponse;
    private String surNameResponse;
    private int ageResponse;

    public UserResponse(String nameResponse, String surNameResponse, int ageResponse) {
        this.nameResponse = nameResponse;
        this.surNameResponse = surNameResponse;
        this.ageResponse = ageResponse;
    }

    public String getNameResponse() {
        return nameResponse;
    }

    public String getSurNameResponse() {
        return surNameResponse;
    }

    public int getAgeResponse() {
        return ageResponse;
    }

}
