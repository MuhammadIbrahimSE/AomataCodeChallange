package com.example.imagegallery.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.imagegallery.R


@BindingAdapter("android:srcImage")
    fun setImageSrc(imageView: ImageView, url: String?) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(FitCenter(), RoundedCorners(8))
        Glide.with(imageView.context).load(url).placeholder(R.drawable.ic_placeholder).apply(requestOptions).into(imageView)
    }
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}


