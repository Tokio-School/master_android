package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("nombre")
    val name:String?,
    val surName:String?,
    val userToken:String?,
    val refreshToken:String,
    val timeStamp:Long)