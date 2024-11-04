package com.horizon.movieuniverse.features.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizon.movieuniverse.model.MovieCategoryResponse
import com.horizon.movieuniverse.model.MovieItemFromCategory
import com.horizon.movieuniverse.model.SliderItem
import com.horizon.movieuniverse.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
    val sliderItems: MutableLiveData<List<SliderItem>> = MutableLiveData()
    val phimLe: MutableLiveData<List<MovieItemFromCategory>> = MutableLiveData()
    val phimBo: MutableLiveData<List<MovieItemFromCategory>> = MutableLiveData()
    val hoatHinh: MutableLiveData<List<MovieItemFromCategory>> = MutableLiveData()
    val tvShows: MutableLiveData<List<MovieItemFromCategory>> = MutableLiveData()

    fun getRecentlyAddedMovies() {
        viewModelScope.launch {
            try {
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
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getMoviesByCategory(categoryId: String) {
        viewModelScope.launch {
            try {
                val response: Response<MovieCategoryResponse> =
                    movieRepository.getMoviesByCategory(categoryId)
                if (response.isSuccessful && response.body() != null) {
                    val movies: List<MovieItemFromCategory> = response.body()!!.data.items
                    when (categoryId) {
                        PHIM_LE -> {
                            phimLe.postValue(movies)
                        }

                        PHIM_BO -> {
                            phimBo.postValue(movies)
                        }

                        HOAT_HINH -> {
                            hoatHinh.postValue(movies)
                        }

                        TV_SHOWS -> {
                            tvShows.postValue(movies)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        const val PHIM_LE = "phim-le"
        const val PHIM_BO = "phim-bo"
        const val HOAT_HINH = "hoat-hinh"
        const val TV_SHOWS = "tv-shows"
    }
}