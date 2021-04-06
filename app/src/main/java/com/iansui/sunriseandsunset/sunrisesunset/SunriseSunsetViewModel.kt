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
                val result = SunriseSunsetApi.retrofitService.getSunriseSunsetData(latitude = 121.043861,
                    longitude = 14.676208,
                    date = "today")
                _status.value = "Success!" +
                                "\nThe data retrieved are " +
                                "\nSunrise: ${result.results.sunrise}" +
                                "\nSunset: ${result.results.sunset}" +
                                "\nSolar Noon: ${result.results.solarNoon}" +
                                "\nDay Length: ${result.results.dayLength}"
            } catch (e: Exception) {
                _status.value = "Failure! " +
                                "\n${e.message}"
            }
        }
    }
}