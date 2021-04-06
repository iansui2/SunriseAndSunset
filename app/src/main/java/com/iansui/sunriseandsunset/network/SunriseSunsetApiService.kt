package com.iansui.sunriseandsunset.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// The base url of the Sunrise and Sunset API Service
private const val BASE_URL = "https://api.sunrise-sunset.org"

// Create a Moshi object and build it
private val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()

// Create a Retrofit object and build it
private val retrofit = Retrofit.Builder()
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
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
                            @Query("date") date: String?): SunriseSunsetData
}

// Create a singleton object for performing the Retrofit request
object SunriseSunsetApi {
    // Create the retrofit object by lazy instantiation
    val retrofitService: SunriseSunsetApiService by lazy {
        retrofit.create(SunriseSunsetApiService::class.java)
    }
}