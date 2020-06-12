package com.rinal.covid19.education

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rinal.covid19.network.EducationProperties
import com.rinal.covid19.R

class EducationViewModel(application: Application) : AndroidViewModel(application){
    private val _educationProperties = MutableLiveData<List<EducationProperties>>()
    val educationProperties: LiveData<List<EducationProperties>>
        get() = _educationProperties

    private val _navigateToDetailEdu = MutableLiveData<EducationProperties>()
    val navigateToDetailEdu: LiveData<EducationProperties>
        get() = _navigateToDetailEdu

    private var itemsProperties: MutableList<EducationProperties> = mutableListOf()

    init {
        getProperties()
    }

    private fun getProperties(){
        val title = getApplication<Application>().resources.getStringArray(R.array.title_education)
        val image = getApplication<Application>().resources.obtainTypedArray(R.array.img_education)
        val desc = getApplication<Application>().resources.getStringArray(R.array.desc_education)
        itemsProperties.clear()
        for (i in title.indices){
            itemsProperties.add(
                EducationProperties(
                    title[i],
                    image.getResourceId(i, 0),
                    desc[i]
                )
            )
        }
        image.recycle()

        _educationProperties.value = itemsProperties
    }

    fun displayEducationDetail(educationProperties: EducationProperties){
        _navigateToDetailEdu.value = educationProperties
    }

    fun displayEducationDetailComplete(){
        _navigateToDetailEdu.value = null
    }
}