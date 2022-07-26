package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class Price(

	@field:SerializedName("current")
	val current: String? = null,

	@field:SerializedName("old")
	val old: String? = null,

	@field:SerializedName("exactCurrent")
	val exactCurrent: Double? = null
)