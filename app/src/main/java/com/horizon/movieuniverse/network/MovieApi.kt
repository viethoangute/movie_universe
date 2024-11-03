package com.horizon.movieuniverse.network

import com.horizon.movieuniverse.model.RecentlyAddedMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("danh-sach/phim-moi-cap-nhat")
    suspend fun getRecentlyAddedMovies(@Query("page") pageId: Int) : Response<RecentlyAddedMovies>
}