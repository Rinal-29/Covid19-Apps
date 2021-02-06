package com.rinal.covid19

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rinal.covid19.education.EducationAdapter
import com.rinal.covid19.home.ApiStatus
import com.rinal.covid19.network.EducationProperties
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("dateUpdated")
fun bindDate(textView: TextView, date: Double?){
    date.let {
        val dateFormat = SimpleDateFormat("EEEE, dd-MMMM-yyyy HH:mm:ss", Locale.getDefault())
        val dateNew = dateFormat.format(date)
        textView.text = dateNew
    }
}

@BindingAdapter("progressStatus")
fun bindProgressBar(statusLoading: ProgressBar, status: ApiStatus?){
    when (status){
        ApiStatus.LOADING -> {
            statusLoading.visibility = View.VISIBLE
        }
        ApiStatus.ERROR -> {
            statusLoading.visibility = View.GONE
        }
        ApiStatus.DONE -> {
            statusLoading.visibility = View.GONE
        }
    }
}

@BindingAdapter("connectionErrorImg")
fun bindConnectionError(image: ImageView, status: ApiStatus?){
    status.let {
        if (status == ApiStatus.ERROR){
            image.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("errorStatus")
fun bindErrorStatus(layout: ConstraintLayout, status: ApiStatus?){
    status.let {
        if (status == ApiStatus.ERROR){
            layout.visibility = View.GONE
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<EducationProperties>){
    val adapter = recyclerView.adapter as EducationAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageData")
fun binImage(image: ImageView, data: Int?){
    data.let {
        if (data != null) {
            image.setImageResource(data)
        }
    }
}

