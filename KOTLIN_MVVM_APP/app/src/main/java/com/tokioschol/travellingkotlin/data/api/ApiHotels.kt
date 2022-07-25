package com.tokioschol.travellingkotlin.data.api

import com.tokioschol.travellingkotlin.data.response.HotelsResponse
import retrofit2.http.GET

interface ApiHotels {

    @GET("/listHotels")
    suspend fun getListHotels(): HotelsResponse

}