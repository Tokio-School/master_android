package com.tokioschol.travellingkotlin.data.response

import com.google.gson.annotations.SerializedName

data class Address(

	@field:SerializedName("obfuscate")
	val obfuscate: Boolean? = null,

	@field:SerializedName("streetAddress")
	val streetAddress: String? = null,

	@field:SerializedName("countryCode")
	val countryCode: String? = null,

	@field:SerializedName("postalCode")
	val postalCode: String? = null,

	@field:SerializedName("locality")
	val locality: String? = null,

	@field:SerializedName("countryName")
	val countryName: String? = null,

	@field:SerializedName("extendedAddress")
	val extendedAddress: String? = null,

	@field:SerializedName("region")
	val region: String? = null
)