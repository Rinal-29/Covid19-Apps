package com.rinal.covid19.network

data class IndonesiaProperties(
    val updated: Double,
    val country: String,
    val cases: Double,
    val todayCases: Double,
    val deaths: Double,
    val todayDeaths: Double,
    val recovered: Double,
    val todayRecovered: Double,
    val active: Double,
    val tests: Double,
    val population: Double
)