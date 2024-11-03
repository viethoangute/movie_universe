package com.horizon.movieuniverse.model

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("totalItems") var totalItems: Int? = null,
    @SerializedName("totalItemsPerPage") var totalItemsPerPage: Int? = null,
    @SerializedName("currentPage") var currentPage: Int? = null,
    @SerializedName("totalPages") var totalPages: Int? = null
)