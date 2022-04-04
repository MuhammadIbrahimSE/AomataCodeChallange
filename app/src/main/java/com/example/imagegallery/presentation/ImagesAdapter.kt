package com.example.imagegallery.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegallery.R
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.databinding.ImagesListItemBinding
import com.example.imagegallery.util.DiffUtilCallBack

class ImagesAdapter(val clickCallBack: (ImagesList.ImagesListItem) -> Unit,) : PagingDataAdapter<ImagesList.ImagesListItem, ImagesAdapter.ViewHolder>(DataDifferntiator) {

    class ViewHolder(val binding: ImagesListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.binding.apply {
            result = dataItem
            this.root.setOnClickListener {
                clickCallBack(dataItem!!)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.images_list_item, parent, false
            )
        )
    }

    object DataDifferntiator : DiffUtil.ItemCallback<ImagesList.ImagesListItem>() {

        override fun areItemsTheSame(oldItem: ImagesList.ImagesListItem, newItem: ImagesList.ImagesListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImagesList.ImagesListItem, newItem: ImagesList.ImagesListItem): Boolean {
            return oldItem == newItem
        }
    }

}
