package com.farhan.tanvir.androidcleanarchitecture.di

import com.example.imagegallery.domain.repository.ImagesRepository
import com.example.imagegallery.domain.usecase.GetImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetImagesUseCase(imagesRepository: ImagesRepository) = GetImagesUseCase(
        imagesRepository
    )
}