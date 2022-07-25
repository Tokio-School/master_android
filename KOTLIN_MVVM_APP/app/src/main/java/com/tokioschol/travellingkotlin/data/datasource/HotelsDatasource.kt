package com.tokioschol.travellingkotlin.data.datasource

import com.tokioschol.travellingkotlin.data.response.HotelsResponse
import kotlinx.coroutines.flow.Flow

interface HotelsDatasource {
    fun getListHotels(): Flow<HotelsResponse>
}
