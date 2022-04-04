package com.example.imagegallery.util

import android.app.Activity
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.imagegallery.R
import com.bumptech.glide.request.target.Target
fun Activity.showToast(toastText: String?) {
    Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(srcImage: String?, prgrsLoader: ProgressBar) {
    prgrsLoader.visible()
    Glide.with(this).load(srcImage).fitCenter().diskCacheStrategy(
        DiskCacheStrategy.AUTOMATIC
    ).listener(object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            prgrsLoader.gone()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            prgrsLoader.gone()
            return false
        }
    }).error(R.drawable.ic_placeholder)
        .into(this)
}

