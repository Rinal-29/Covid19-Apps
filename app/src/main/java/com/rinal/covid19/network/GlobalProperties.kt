package com.rinal.covid19.network

data class GlobalProperties(
   val updated: Double,
   val cases: Double,
   val todayCases: Double,
   val deaths: Double,
   val todayDeaths: Double,
   val recovered: Double,
   val todayRecovered: Double,
   val active: Double,
   val critical: Double,
   val tests: Double,
   val affectedCountries: Double
)