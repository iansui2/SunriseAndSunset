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
     * and updates [SunriseSunset] [LiveData]
     */
    private fun getSunriseSunsetData() {
        _status.value = "Loading..."
        viewModelScope.launch {
            try {
                val result = SunriseSunsetApi.retrofitService.getSunriseSunsetData(latitude = 14.676208,
                    longitude = 121.043861,
                    date = "today")
                _status.value = result
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}