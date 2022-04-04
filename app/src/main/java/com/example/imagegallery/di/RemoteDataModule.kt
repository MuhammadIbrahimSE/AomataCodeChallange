package com.example.imagegallery.di

import com.example.imagegallery.data.api.ImageService
import com.example.imagegallery.data.datasource.ImagesDataSource
import com.example.imagegallery.data.datasourceimpl.ImagesDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideImagesRemoteDataSource(apiService: ImageService) :ImagesDataSource  =
        ImagesDataSourceImpl(apiService)
}