package com.example.usersapiconsume.data.model

data class LocationModel(
    val city: String? = "",
    val coordinates: CoordinatesModel? = CoordinatesModel(),
    val country: String? = "",
    val postcode: Int? = 0,
    val state: String? = "",
    val street: StreetModel? = StreetModel(),
    val timezone: TimezoneModel? = TimezoneModel()
)