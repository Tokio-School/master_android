package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class RatePlan(

	@field:SerializedName("features")
	val features: Features? = null,

	@field:SerializedName("price")
	val price: Price? = null
)