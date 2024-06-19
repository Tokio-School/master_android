package com.example.mapsapi

data class GeoDbResponse(
    val data: List<CityData>
)

data class CityData(
    val city: String,
    val latitude: Double,
    val longitude: Double
)
