package com.horizon.movieuniverse.repository

import com.horizon.movieuniverse.model.RecentlyAddedMovies
import com.horizon.movieuniverse.network.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi
) {
    suspend fun getRecentlyAddedMovies() : Response<RecentlyAddedMovies> {
        return withContext(Dispatchers.IO) {
            movieApi.getRecentlyAddedMovies(1)
        }
    }
}