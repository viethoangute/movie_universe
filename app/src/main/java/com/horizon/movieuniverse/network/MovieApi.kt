package com.horizon.movieuniverse.network

import com.horizon.movieuniverse.model.MovieCategoryResponse
import com.horizon.movieuniverse.model.RecentlyAddedMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("danh-sach/phim-moi-cap-nhat")
    suspend fun getRecentlyAddedMovies(@Query("page") pageId: Int): Response<RecentlyAddedMovies>

    @GET("v1/api/danh-sach/{category}")
    suspend fun getMoviesByCategory(
        @Path("category") category: String,
        @Query("limit") limit: Int = 8
    ): Response<MovieCategoryResponse>
}