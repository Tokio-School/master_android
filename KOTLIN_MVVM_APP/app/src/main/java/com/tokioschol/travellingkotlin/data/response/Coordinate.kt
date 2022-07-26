package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class Coordinate(

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)