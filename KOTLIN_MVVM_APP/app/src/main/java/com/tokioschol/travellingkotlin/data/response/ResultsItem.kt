package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("ratePlan")
	val ratePlan: RatePlan? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("coordinate")
	val coordinate: Coordinate? = null,

	@field:SerializedName("guestReviews")
	val guestReviews: GuestReviews? = null,

	@field:SerializedName("supplierHotelId")
	val supplierHotelId: Int? = null,

	@field:SerializedName("neighbourhood")
	val neighbourhood: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("isAlternative")
	val isAlternative: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("starRating")
	val starRating: Int? = null,

	@field:SerializedName("optimizedThumbUrls")
	val optimizedThumbUrls: OptimizedThumbUrls? = null,

	@field:SerializedName("providerType")
	val providerType: String? = null
)