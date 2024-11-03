package com.horizon.movieuniverse.model

import com.google.gson.annotations.SerializedName

data class RecentlyAddedMovies(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("items") var items: ArrayList<MovieItem> = arrayListOf(),
    @SerializedName("pagination") var pagination: Pagination? = Pagination()
)