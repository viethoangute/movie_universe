package com.horizon.movieuniverse.features.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizon.movieuniverse.model.SliderItem
import com.horizon.movieuniverse.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    val sliderItems: MutableLiveData<List<SliderItem>> = MutableLiveData()

    fun getRecentlyAddedMovies() {
        viewModelScope.launch {
            val response = movieRepository.getRecentlyAddedMovies()
            if (response.isSuccessful) {
                val itemToShow = mutableListOf<SliderItem>()
                response.body()?.items?.map { item ->
                    val id = item.id.toString()
                    val imageURL = item.posterUrl.toString()
                    itemToShow.add(SliderItem(id, imageURL))
                }
                sliderItems.postValue(itemToShow)
            }
        }
    }
}