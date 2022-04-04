package com.example.imagegallery.data.datasourceimpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.imagegallery.data.api.ImageService
import com.example.imagegallery.data.datasource.ImagesDataSource
import com.example.imagegallery.data.model.ImagesList
import kotlinx.coroutines.flow.Flow

class ImagesDataSourceImpl(val apiService: ImageService) : ImagesDataSource {

    override suspend fun getPhotos():Flow<PagingData<ImagesList.ImagesListItem>> {
        return Pager(PagingConfig(pageSize = 3)) {
            ImageDataSource(apiService)
        }.flow
    }
}