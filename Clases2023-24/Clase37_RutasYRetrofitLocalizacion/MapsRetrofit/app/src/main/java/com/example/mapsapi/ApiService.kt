package com.example.mapsapi


import com.google.android.gms.awareness.snapshot.LocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("x-rapidapi-key: 69df43047cmshc76670666f7d395p1690adjsne2b2dc964bd1", "x-rapidapi-host: wft-geo-db.p.rapidapi.com'")
    @GET("v1/geo/cities")
    fun getLocations(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): Call<GeoDbResponse>
}
