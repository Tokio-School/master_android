package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL = "https://ws.detectlanguage.com";

    public static final String BASE_URL2 = "https://jsonplaceholder.typicode.com";
    private  Retrofit getRetrofit(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(url);

                // Dependencia que permite transformar el json
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    public API(String url){
            service=getRetrofit(url).create(APIService.class);
    }

    APIService service;

}
