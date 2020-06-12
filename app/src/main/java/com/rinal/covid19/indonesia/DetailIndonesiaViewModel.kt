package com.rinal.covid19.indonesia

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rinal.covid19.network.CovidApi
import com.rinal.covid19.network.IndonesiaProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailIndonesiaViewModel: ViewModel(){

    private val _indonesiaProperties = MutableLiveData<IndonesiaProperties>()
    val indonesiaProperties: LiveData<IndonesiaProperties>
        get() = _indonesiaProperties

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getProperties()
    }

    private fun getProperties(){
        coroutineScope.launch {
            val deferredIndonesiaProperties = CovidApi.retrofitService.getIndonesiaProperties()
            try {
                val indonesiaProperties = deferredIndonesiaProperties.await()

                _indonesiaProperties.value = indonesiaProperties
            } catch (e : Exception){
                Log.i("Error : ", e.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}