package com.iansui.sunriseandsunset.sunrisesunset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iansui.sunriseandsunset.network.SunriseSunsetApi
import kotlinx.coroutines.launch

class SunriseSunsetViewModel: ViewModel() {

    // Internal MutableLiveData that stores the status of the request
    private val _status = MutableLiveData<String>()

    // External immutable LiveData for the request status
    val status: LiveData<String> = _status

    // Internal MutableLiveData that stores the sunrise of the request
    private val _sunrise = MutableLiveData<String>()

    // External immutable LiveData for the request status
    val sunrise: LiveData<String> = _sunrise

    // Internal MutableLiveData that stores the sunset of the request
    private val _sunset = MutableLiveData<String>()

    // External immutable LiveData for the request status
    val sunset: LiveData<String> = _sunset

    // Internal MutableLiveData that stores the solar noon of the request
    private val _solar_noon = MutableLiveData<String>()

    // External immutable LiveData for the request status
    val solar_noon: LiveData<String> = _solar_noon

    // Internal MutableLiveData that stores the day length of the request
    private val _day_length = MutableLiveData<String>()

    // External immutable LiveData for the request status
    val day_length: LiveData<String> = _day_length

    /**
     * Call getSunriseSunsetData() on init to display status
     * immediately the app first launches
     */
    init {
        getSunriseSunsetData()
    }

    /**
     * Get SunriseSunset information from the SunriseSunset API Retrofit Service
     * and updates [LiveData]
     */
    private fun getSunriseSunsetData() {
        _status.value = "Loading..."
        viewModelScope.launch {
            try {
                val sunriseSunsetData = SunriseSunsetApi.retrofitService.getSunriseSunsetData(latitude = 121.043861,
                    longitude = 14.676208,
                    date = "today")
                _status.value = "Success!"
                _sunrise.value = sunriseSunsetData.results.sunrise
                _sunset.value = sunriseSunsetData.results.sunset
                _solar_noon.value = sunriseSunsetData.results.solarNoon
                _day_length.value = sunriseSunsetData.results.dayLength
            } catch (e: Exception) {
                _status.value = "Failure! " +
                                "\n${e.message}"
            }
        }
    }
}