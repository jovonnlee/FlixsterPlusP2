package com.example.flixsterplusp2

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


class Movies {
    @SerializedName("original_title")
    var movieTitle: String? = null

    @SerializedName("overview")
    var movieDescription: String? = null

    @SerializedName("poster_path")
    var movieImage: String? = null

    @SerializedName("release_date")
    var movRelDate: String? = null

    @SerializedName("original_language")
    var movOrigLang: String? = null
}