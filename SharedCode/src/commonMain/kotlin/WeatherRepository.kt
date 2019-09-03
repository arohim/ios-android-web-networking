package com.jetbrains.handson.mpp.mobile

interface WeatherRepository {

    fun sendTracking(data1: String, callback: (data: String) -> Unit)

}