package com.example.flixsterplusp2

import com.google.gson.annotations.SerializedName

class TvShows {
    @SerializedName("name")
    var showName: String? = null

    @SerializedName("poster_path")
    var showImage: String? = null

    @SerializedName("overview")
    var tvDescription: String? = null
}