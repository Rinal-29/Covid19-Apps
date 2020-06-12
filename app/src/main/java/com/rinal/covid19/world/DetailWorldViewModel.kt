package com.rinal.covid19.world

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rinal.covid19.network.CovidApi
import com.rinal.covid19.network.GlobalProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailWorldViewModel: ViewModel() {
    private val _globalProperties = MutableLiveData<GlobalProperties>()
    val globalProperties: LiveData<GlobalProperties>
        get() = _globalProperties

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getGlobalProperties()
    }

    private fun getGlobalProperties(){
        coroutineScope.launch {
            val deferredGlobalProperties = CovidApi.retrofitService.getGlobalsProperties()
            try {
                val globalProperties = deferredGlobalProperties.await()
                _globalProperties.value = globalProperties
            } catch (e: Exception){
                Log.i("Error : ", e.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}