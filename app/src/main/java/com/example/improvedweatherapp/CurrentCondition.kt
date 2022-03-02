package com.example.improvedweatherapp

data class CurrentCondition (
    val weather: List<WeatherCondition>,
    val main: Currents,
    val name: String,
        )