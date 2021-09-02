package com.tokioschol.tp8_viewbinding_databinding.viewbinding.domain;

public class SimpleModel {
    private String title;
    private String subTitle;

    public SimpleModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
