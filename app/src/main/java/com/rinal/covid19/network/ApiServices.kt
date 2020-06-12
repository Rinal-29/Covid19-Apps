package com.rinal.covid19.network

import androidx.lifecycle.LiveData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://corona.lmao.ninja/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ApiServices {
    @GET("all")
    fun getGlobalsProperties() : Deferred<GlobalProperties>

    @GET("countries/Indonesia")
    fun getIndonesiaProperties() : Deferred<IndonesiaProperties>
}

object CovidApi {
    val retrofitService : ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}