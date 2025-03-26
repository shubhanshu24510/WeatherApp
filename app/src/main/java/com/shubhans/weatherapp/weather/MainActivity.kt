package com.shubhans.weatherapp.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubhans.weatherapp.weather.presentation.WeatherScreen
import com.shubhans.weatherapp.weather.presentation.WeatherViewModel
import com.shubhans.weatherapp.weather.presentation.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherViewModel: WeatherViewModel by viewModels()
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.Companion
                        .fillMaxSize()
                        .padding(20.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherScreen(weatherViewModel)
                }
            }
        }
    }
}