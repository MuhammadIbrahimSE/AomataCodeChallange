package com.example.imagegallery.util

import androidx.recyclerview.widget.DiffUtil
import com.example.imagegallery.data.model.ImagesList

open class DiffUtilCallBack(
    private val oldData: List<ImagesList.ImagesListItem>,
    private val newData: List<ImagesList.ImagesListItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldData.size
    }

    override fun getNewListSize(): Int {
        return newData.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }
}