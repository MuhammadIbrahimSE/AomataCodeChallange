package com.example.imagegallery.domain.repository

import androidx.paging.PagingData
import com.example.imagegallery.data.model.ImagesList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Query

abstract class ImagesRepository {
    abstract suspend fun getPhotos(): Flow<PagingData<ImagesList.ImagesListItem>>
}