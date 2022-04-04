package com.example.imagegallery.data.repository

import androidx.paging.PagingData
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.repository.ImagesRepository
import com.example.imagegallery.data.datasource.ImagesDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class ImagesRepositoryImpl(private val imagesDataSource: ImagesDataSource) : ImagesRepository() {
    override suspend fun getPhotos(): Flow<PagingData<ImagesList.ImagesListItem>> =
        imagesDataSource.getPhotos()
}