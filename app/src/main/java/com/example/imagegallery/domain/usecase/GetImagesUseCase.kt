package com.example.imagegallery.domain.usecase

import androidx.paging.PagingData
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.repository.ImagesRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class GetImagesUseCase(private val repository: ImagesRepository) {
    suspend fun execute(): Flow<PagingData<ImagesList.ImagesListItem>> = repository.getPhotos()
}