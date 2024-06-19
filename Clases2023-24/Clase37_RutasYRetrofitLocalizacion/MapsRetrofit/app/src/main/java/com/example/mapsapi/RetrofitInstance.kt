package com.example.mapsapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Probando con la API de RapidAPI - GeoDB Cities
object RetrofitInstance {
    private const val BASE_URL = "https://wft-geo-db.p.rapidapi.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
