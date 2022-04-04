package com.example.imagegallery.data.datasource

import androidx.paging.PagingData
import com.example.imagegallery.data.model.ImagesList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ImagesDataSource {
     suspend fun getPhotos(): Flow<PagingData<ImagesList.ImagesListItem>>
}