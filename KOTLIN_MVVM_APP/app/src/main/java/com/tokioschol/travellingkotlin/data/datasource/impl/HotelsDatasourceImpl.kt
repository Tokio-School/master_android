package com.tokioschol.travellingkotlin.data.datasource.impl

import com.tokioschol.travellingkotlin.data.api.ApiHotels
import com.tokioschol.travellingkotlin.data.datasource.HotelsDatasource
import com.tokioschol.travellingkotlin.data.response.HotelsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelsDatasourceImpl @Inject constructor(
    private val apiHotels: ApiHotels
): HotelsDatasource {

    override fun getListHotels(): Flow<HotelsResponse> = flow {
        emit(apiHotels.getListHotels())
    }

}
