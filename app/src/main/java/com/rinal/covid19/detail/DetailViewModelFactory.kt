package com.rinal.covid19.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rinal.covid19.network.EducationProperties
import java.lang.IllegalArgumentException

class DetailViewModelFactory(
    private val educationProperties: EducationProperties
): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailEducationViewModel::class.java)){
            return DetailEducationViewModel(educationProperties) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}