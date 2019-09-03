package com.jetbrains.handson.mpp.mobile

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class WeatherRepositoryImpl constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    override fun sendTracking(data1: String, callback: (data: String) -> Unit) {
        launch(coroutineContext) {
            val weathers = weatherApi.fetchWeather()
            callback(weathers)
        }.invokeOnCompletion {
            println("fetch weather successfully")
        }
    }

}