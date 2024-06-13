package com.example.retrofit;

public class Detection {
    private String language;
    private boolean isReliable;
    private double confidence;

    public Detection(String language, boolean isReliable, double confidence) {
        this.language = language;
        this.isReliable = isReliable;
        this.confidence = confidence;
    }
    public Detection() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isReliable() {
        return isReliable;
    }

    public void setReliable(boolean reliable) {
        isReliable = reliable;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
