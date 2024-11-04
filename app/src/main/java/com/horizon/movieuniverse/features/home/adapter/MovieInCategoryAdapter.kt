package com.horizon.movieuniverse.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.horizon.movieuniverse.databinding.MovieItemBinding
import com.horizon.movieuniverse.model.MovieItemFromCategory

class MovieInCategoryAdapter(private val films: List<MovieItemFromCategory>) :
    RecyclerView.Adapter<MovieInCategoryAdapter.FilmViewHolder>() {
    inner class FilmViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: MovieItemFromCategory) {
            binding.tvMovieName.text = film.name
            Glide.with(binding.root)
                .load(PREFIX_IMAGE_URL + film.posterUrl)
                .into(binding.imvPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(films[position])
    }

    override fun getItemCount(): Int = films.size

    companion object {
        private const val PREFIX_IMAGE_URL = "https://phimimg.com/"
    }
}