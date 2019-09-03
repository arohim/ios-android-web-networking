package com.jetbrains.handson.mpp.mobile

import io.ktor.client.HttpClient
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.url

class WeatherApi {

    private val client by lazy { makeHttpClient() }

    private fun makeHttpClient(): HttpClient {
        return HttpClient {
            expectSuccess = false
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

    suspend fun fetchWeather(): String {
        return client.get {
            url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }
    }

    companion object {
        private const val baseUrl = "https://samples.openweathermap.org"
    }

}