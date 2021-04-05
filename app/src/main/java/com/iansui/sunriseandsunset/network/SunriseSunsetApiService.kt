package com.iansui.sunriseandsunset.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// The base url of the Sunrise and Sunset API Service
private const val BASE_URL = "https://api.sunrise-sunset.org"

// Create a Retrofit object and build it
private val retrofit = Retrofit.Builder()
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()

interface SunriseSunsetApiService {
    /**
     * Perform a GET request to the ApiService using Retrofit
     * and save the data into a String
     */
    @GET("json")
    suspend fun getSunriseSunsetData(@Query("lat") latitude: Double?,
                            @Query("lng") longitude: Double?,
                            @Query("date") date: String?): String
}

// Create a singleton object for performing the Retrofit request
object SunriseSunsetApi {
    // Create the retrofit object by lazy instantiation
    val retrofitService: SunriseSunsetApiService by lazy {
        retrofit.create(SunriseSunsetApiService::class.java)
    }
}