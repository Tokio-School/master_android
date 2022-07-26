package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class Pagination(

	@field:SerializedName("nextPageGroup")
	val nextPageGroup: String? = null,

	@field:SerializedName("nextPageNumber")
	val nextPageNumber: Int? = null,

	@field:SerializedName("pageGroup")
	val pageGroup: String? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null,

	@field:SerializedName("nextPageStartIndex")
	val nextPageStartIndex: Int? = null
)