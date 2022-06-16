package com.tokioschol.travellingkotlin.data.response

data class UserResponse(val name:String?,val surName:String?,val userToken:String?, val refreshToken:String, val timeStamp:Long)