package com.tokioschol.travellingkotlin.data.repository

import com.tokioschol.travellingkotlin.data.datasource.HotelsDatasource
import com.tokioschol.travellingkotlin.data.mappers.matToHotel
import com.tokioschol.travellingkotlin.domain.models.Hotel
import com.tokioschol.travellingkotlin.domain.repository.HotelsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HotelsRepositoryImpl @Inject constructor(
    private val datasource: HotelsDatasource,
) : HotelsRepository {

    override fun getListHotels(): Flow<List<Hotel>> {
        return datasource.getListHotels()
            .map {
                it.matToHotel()
            }
    }
}