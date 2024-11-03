package com.horizon.movieuniverse.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.horizon.movieuniverse.databinding.SliderItemBinding
import com.horizon.movieuniverse.model.SliderItem

class SliderAdapter(private val items: List<SliderItem>) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(private val binding: SliderItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sliderItem: SliderItem) {
            Glide.with(binding.image.context)
                .load(sliderItem.imageURL)
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = SliderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val actualPosition = position % items.size
        holder.bind(items[actualPosition])
    }

    override fun getItemCount(): Int {
        return Integer.MAX_VALUE
    }
}

