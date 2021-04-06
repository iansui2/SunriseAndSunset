package com.iansui.sunriseandsunset.network

import com.squareup.moshi.Json

data class SunriseSunsetData (
        // used to map results from JSON to the results variable in our class
        @Json(name = "results") val results: Results
        )

data class Results (
        // used to map sunrise from JSON to the sunrise variable in our class
        @Json(name = "sunrise") val sunrise: String,
        // used to map sunset from JSON to the sunset variable in our class
        @Json(name = "sunset") val sunset: String,
        // used to map solar_noon from JSON to the solarNoon variable in our class
        @Json(name = "solar_noon") val solarNoon: String,
        // used to map day_length from JSON to the dayLength variable in our class
        @Json(name = "day_length") val dayLength: String
        )

