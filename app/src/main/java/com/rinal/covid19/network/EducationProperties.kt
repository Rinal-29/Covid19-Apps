package com.rinal.covid19.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EducationProperties (
    val title: String,
    val imgEducation: Int,
    val description: String
) : Parcelable