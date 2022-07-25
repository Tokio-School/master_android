package com.tokioschol.travellingkotlin.domain.usecase

import com.tokioschol.travellingkotlin.core.base.FlowUseCase
import com.tokioschol.travellingkotlin.core.di.domain.di.IoDispatcher
import com.tokioschol.travellingkotlin.domain.models.Hotel
import com.tokioschol.travellingkotlin.domain.models.User
import com.tokioschol.travellingkotlin.domain.repository.HotelsRepository
import com.tokioschol.travellingkotlin.domain.repository.LoginRespository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class GetListHotelsUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val hotelRespository: HotelsRepository
): FlowUseCase<Unit, List<Hotel>>(dispatcher) {


    override fun execute(params: Unit): Flow<List<Hotel>> {
        return hotelRespository.getListHotels()
    }
}