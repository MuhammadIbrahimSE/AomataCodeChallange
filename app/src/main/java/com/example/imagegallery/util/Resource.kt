package com.example.imagegallery.util

sealed class Resource<T>(val data: T? = null, val error: String? = null) {

    class Loading<T> : Resource<T>()
    class Success<T>(data: T? = null,message: String? = null) : Resource<T>(data = data,message)
    class Error<T>(error: String) : Resource<T>(error = error)
}
