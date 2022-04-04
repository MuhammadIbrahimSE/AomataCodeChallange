package com.example.imagegallery.presentation

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegallery.R
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.databinding.ActivityMainBinding
import com.example.imagegallery.util.Constants
import com.example.imagegallery.util.Constants.IMAGE_URL
import com.example.imagegallery.util.Resource
import com.example.imagegallery.util.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ImagesViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var imagesAdapter: ImagesAdapter
    private var imagesList: MutableList<ImagesList.ImagesListItem> = mutableListOf()
    var spanList = mutableListOf<String>("Select number of colums", "1", "2", "3", "4", "5")
    var state: Parcelable? = null

    companion object {
        const val ANGRY = "\uD83D\uDE28 "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        setUpAdapter()
        setSpanCountSpinner()
        viewModel.imagesResponse.observe(this@MainActivity, Observer { resource ->
            when (resource) {
                is Resource.Loading -> binding.pbLoading.visibility = View.VISIBLE
                is Resource.Error -> {
                    showToast(resource.error)
                    binding.pbLoading.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.pbLoading.visibility = View.GONE
                    lifecycleScope.launch {
                        imagesAdapter.submitData(resource.data!!)
                    }
                }
            }
        })
        viewModel.getMovies()
    }

    private fun gotoDetailActivity(fullImagePath: String) {
        startActivity(
            Intent(this, ImageDetailActivity::class.java).putExtra(
                IMAGE_URL,
                fullImagePath
            )
        )
    }

    private fun setUpAdapter() {
        imagesAdapter = ImagesAdapter() { data ->
            gotoDetailActivity(data.urls?.full!!)
        }
        binding.rvImages.apply {
            setHasFixedSize(true)
            val footerAdapter = CustomLoadStateAdapter {
                imagesAdapter.retry()
            }
            adapter = imagesAdapter.withLoadStateFooter(
                footer = footerAdapter
            )

            val layoutManager = GridLayoutManager(this@MainActivity, 3)
            this.layoutManager = layoutManager
            layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == imagesAdapter.itemCount && footerAdapter.itemCount > 0) {
                        2
                    } else {
                        1
                    }
                }
            }
            if (state != null) {
                binding.rvImages.layoutManager?.onRestoreInstanceState(state)
            }
        }


        imagesAdapter.addLoadStateListener { loadStates ->
            when (loadStates.source.refresh) {
                is LoadState.NotLoading -> {
                    binding.pbLoading.visibility = GONE
                }
                is LoadState.Loading -> {
                    if (imagesAdapter.itemCount == 0) {
                        binding.pbLoading.visibility = VISIBLE
                    } else {
                        binding.pbLoading.visibility = GONE
                    }
                }
                is LoadState.Error -> {
                    binding.pbLoading.visibility = GONE
                }
            }
        }
    }


    fun setSpanCountSpinner() {
        val spinnerAdapter = object : ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            spanList
        ) {

            override fun isEnabled(position: Int): Boolean {

                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView =
                    super.getDropDownView(position, convertView, parent) as TextView
                if (position == 0) {
                    view.setTextColor(Color.GRAY)
                } else {
                    view.setTextColor(Color.BLACK);
                }
                return view
            }

        }
        binding.spnSpanCount.adapter = spinnerAdapter
        binding.spnSpanCount.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    if (p2 > 0)
                        changeSpanCount(spanList[p2].toInt())
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
    }

    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun changeSpanCount(spans: Int) {
        val layoutManager = binding.rvImages.layoutManager as GridLayoutManager
        layoutManager?.spanCount = spans
        layoutManager.requestLayout()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            state = savedInstanceState.getParcelable(Constants.LIST_POSITION)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(
            Constants.LIST_POSITION,
            binding.rvImages.layoutManager?.onSaveInstanceState()
        )
    }
}