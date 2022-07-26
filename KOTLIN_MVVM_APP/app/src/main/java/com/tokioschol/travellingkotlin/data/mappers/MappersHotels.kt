package com.tokioschol.travellingkotlin.data.mappers

import com.tokioschol.travellingkotlin.data.response.Address
import com.tokioschol.travellingkotlin.data.response.Coordinate
import com.tokioschol.travellingkotlin.data.response.HotelsResponse
import com.tokioschol.travellingkotlin.domain.models.AdressHotel
import com.tokioschol.travellingkotlin.domain.models.Hotel
import com.tokioschol.travellingkotlin.domain.models.Location


fun HotelsResponse.matToHotel() =
    results?.map {
        Hotel(
            img = it?.optimizedThumbUrls?.srpDesktop?.split("?")?.get(0) ?: "",
            name = it?.name ?: "",
            adress = getAdress(it?.address),
            location = getLocation(it?.coordinate)
        )
    }.orEmpty()

fun getLocation(coordinate: Coordinate?): Location = Location(coordinate?.lat, coordinate?.lon)


fun getAdress(address: Address?): AdressHotel =
    AdressHotel(
        city = address?.locality ?: "",
        street = address?.streetAddress ?: "",
        postalCode = address?.postalCode ?: ""
    )

