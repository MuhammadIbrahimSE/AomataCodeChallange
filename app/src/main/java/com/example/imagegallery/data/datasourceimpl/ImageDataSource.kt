package com.example.imagegallery.data.datasourceimpl

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.imagegallery.data.api.ImageService
import com.example.imagegallery.data.model.ImagesList

class ImageDataSource(private val apiService: ImageService) : PagingSource<Int, ImagesList.ImagesListItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImagesList.ImagesListItem> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiService.getPhotos(currentLoadingPageKey)
            val responseData = mutableListOf<ImagesList.ImagesListItem>()
            val data = response.body() ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImagesList.ImagesListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}