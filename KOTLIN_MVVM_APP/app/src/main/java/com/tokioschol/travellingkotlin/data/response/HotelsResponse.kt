package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class HotelsResponse(

	@SerializedName("pagination")
	val pagination: Pagination? = null,

	@SerializedName("totalCount")
	val totalCount: Int? = null,

	@SerializedName("results")
	val results: List<ResultsItem?>? = null
)