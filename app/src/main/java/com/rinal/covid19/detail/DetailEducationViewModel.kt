package com.rinal.covid19.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rinal.covid19.network.EducationProperties

class DetailEducationViewModel(educationProperties: EducationProperties) : ViewModel(){

    private val _educationProperties = MutableLiveData<EducationProperties>()
    val educationProperties: LiveData<EducationProperties>
        get() = _educationProperties

    init {
        _educationProperties.value = educationProperties
    }
}