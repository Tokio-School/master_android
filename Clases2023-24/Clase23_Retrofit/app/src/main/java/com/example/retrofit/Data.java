package com.example.retrofit;

import java.util.ArrayList;


public class Data {
    private ArrayList<Detection> detections;

    public ArrayList<Detection> getDetections() {
        return detections;
    }

    public void setDetections(ArrayList<Detection> detections) {
        this.detections = detections;
    }

    public Data(ArrayList<Detection> detections) {
        this.detections = detections;
    }

    public Data() {
    }
}
