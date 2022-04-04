package com.example.imagegallery.data.api

import com.example.imagegallery.data.model.ImagesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {
    @GET("photos")
    suspend fun getPhotos(@Query("page") page: Int): Response<ImagesList>
}