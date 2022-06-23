package com.tokioschol.travellingkotlin.data.mappers

import com.tokioschol.travellingkotlin.data.response.UserResponse
import com.tokioschol.travellingkotlin.domain.models.User


fun UserResponse.mapToUser() = User(
    name = this.name ?: "",
    surName = this.surName ?: "sin apellido",
    age = 23
)
