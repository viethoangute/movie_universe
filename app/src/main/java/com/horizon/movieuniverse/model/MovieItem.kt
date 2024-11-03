package com.horizon.movieuniverse.model

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("modified") var modified: Modified? = Modified(),
    @SerializedName("_id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("origin_name") var originName: String? = null,
    @SerializedName("poster_url") var posterUrl: String? = null,
    @SerializedName("thumb_url") var thumbUrl: String? = null,
    @SerializedName("year") var year: Int? = null
)