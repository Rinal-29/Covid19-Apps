package com.rinal.covid19.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rinal.covid19.network.CovidApi
import com.rinal.covid19.network.GlobalProperties
import com.rinal.covid19.network.IndonesiaProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiStatus { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel(){

    private val _globalProperties = MutableLiveData<GlobalProperties>()
    val globalProperties: LiveData<GlobalProperties>
        get() = _globalProperties

    private val _indonesiaProperties = MutableLiveData<IndonesiaProperties>()
    val indonesiaProperties: LiveData<IndonesiaProperties>
        get() = _indonesiaProperties

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        getProperties()
    }

    private fun getProperties(){
        coroutineScope.launch {
            val getPropertiesDeferred = CovidApi.retrofitService.getGlobalsProperties()
            val getPropertiesDeferredIndonesia = CovidApi.retrofitService.getIndonesiaProperties()
            try {
                _status.value = ApiStatus.LOADING
                val resultProperties = getPropertiesDeferred.await()
                val resultIndonesiaProperties = getPropertiesDeferredIndonesia.await()

                _status.value = ApiStatus.DONE
                _globalProperties.value = resultProperties
                _indonesiaProperties.value = resultIndonesiaProperties
            } catch (e: Exception){
                _status.value = ApiStatus.ERROR
                Log.i("error", e.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}