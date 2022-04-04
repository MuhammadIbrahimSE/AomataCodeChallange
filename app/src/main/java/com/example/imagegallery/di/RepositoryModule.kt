package com.farhan.tanvir.androidcleanarchitecture.di


import com.example.imagegallery.data.repository.ImagesRepositoryImpl
import com.example.imagegallery.domain.repository.ImagesRepository
import com.example.imagegallery.data.datasource.ImagesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideImagesRepository(
        imagesDataSource: ImagesDataSource
    ): ImagesRepository =
        ImagesRepositoryImpl(imagesDataSource)
}