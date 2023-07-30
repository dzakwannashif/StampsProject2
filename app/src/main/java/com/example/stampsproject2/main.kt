package com.example.stampsproject2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    val url = "https://api.openweathermap.org/data/2.5/forecast?lat=-6.2146&lon=106.8451&appid=0e61f7242589da44d8bd8e2d26d57831"

    getApi(url) {
        response, error ->
        if (error != null) {
            println("Error: $error")
        } else {
            println("Response: $response")
        }
    }

}