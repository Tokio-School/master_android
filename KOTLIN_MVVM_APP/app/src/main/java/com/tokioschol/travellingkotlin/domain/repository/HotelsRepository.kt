package com.tokioschol.travellingkotlin.domain.repository

import com.tokioschol.travellingkotlin.domain.models.Hotel
import kotlinx.coroutines.flow.Flow

interface HotelsRepository {
    fun getListHotels(): Flow<List<Hotel>>
}