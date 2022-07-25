package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class Features(

	@field:SerializedName("paymentPreference")
	val paymentPreference: Boolean? = null,

	@field:SerializedName("noCCRequired")
	val noCCRequired: Boolean? = null
)