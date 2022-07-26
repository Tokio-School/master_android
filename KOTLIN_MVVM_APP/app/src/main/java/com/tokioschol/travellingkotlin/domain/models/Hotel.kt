package com.tokioschol.travellingkotlin.domain.models

data class Hotel(val img: String, val name: String= "", val adress: AdressHotel, val location: Location)

data class AdressHotel(val city: String, val street: String, val postalCode: String)
data class Location(val lat: Double?, val long: Double?)
