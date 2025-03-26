package com.shubhans.weatherapp.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.weatherapp.weather.data.remote.RetrofitFactory
import com.shubhans.weatherapp.weather.domain.model.WeatherData
import com.shubhans.weatherapp.weather.domain.response.NetworkResponse
import com.shubhans.weatherapp.weather.presentation.components.Constant
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi = RetrofitFactory.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherData>>()
    val weatherResult: LiveData<NetworkResponse<WeatherData>> = _weatherResult
    fun getData(city: String) {
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather(Constant.API_KEY, city)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error("Failed to load data")
                }
            } catch (e: Exception) {
                _weatherResult.value = NetworkResponse.Error("Failed to load data")
            }
        }
    }
}