package com.example.imagegallery.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.imagegallery.R
import com.example.imagegallery.databinding.ActivityImageDetailBinding
import com.example.imagegallery.databinding.ActivityMainBinding
import com.example.imagegallery.util.Constants.IMAGE_URL
import com.example.imagegallery.util.loadImage

class ImageDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageDetailBinding
    lateinit var comingImageURl: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        //also can get through viewmodel using savestatehandle
        intent?.let {
            comingImageURl = it.getStringExtra(IMAGE_URL)!!
        }
        if (this::comingImageURl.isInitialized) {
            binding.ivDetailedImage.loadImage(comingImageURl, binding.pbLoading)
        }
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}