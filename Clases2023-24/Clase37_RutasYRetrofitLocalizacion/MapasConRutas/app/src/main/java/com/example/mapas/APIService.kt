package com.example.mapsapi

import com.example.mapas.RouteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/v2/directions/driving-car")
    fun getRoute(
        @Query("start", encoded = true) start: String,
        @Query("end", encoded = true) end: String,
        @Query("api_key") apiKey: String // Añadir el parámetro api_key
    ): Call<RouteResponse>
}
