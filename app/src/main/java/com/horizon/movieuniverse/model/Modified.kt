package com.horizon.movieuniverse.model

import com.google.gson.annotations.SerializedName

data class Modified(
    @SerializedName("time") var time: String? = null
)