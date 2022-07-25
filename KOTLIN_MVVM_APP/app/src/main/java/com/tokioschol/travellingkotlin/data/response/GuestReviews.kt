package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class GuestReviews(

	@field:SerializedName("badge")
	val badge: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("unformattedRating")
	val unformattedRating: Double? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("scale")
	val scale: Int? = null,

	@field:SerializedName("badgeText")
	val badgeText: String? = null
)