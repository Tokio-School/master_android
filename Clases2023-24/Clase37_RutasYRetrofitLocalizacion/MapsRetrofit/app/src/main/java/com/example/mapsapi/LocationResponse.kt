package com.example.mapsapi

data class LocationResponse(
    val data: List<LocationData>
)

data class LocationData(
    val city: String,
    val latitude: Double,
    val longitude: Double
)
