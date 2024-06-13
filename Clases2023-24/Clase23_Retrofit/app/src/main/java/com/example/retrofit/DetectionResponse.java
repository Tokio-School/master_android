package com.example.retrofit;

public class DetectionResponse {
    private Data data;

    public DetectionResponse(Data data) {
        this.data = data;
    }
    public DetectionResponse() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
