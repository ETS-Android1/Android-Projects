package com.example.gallery

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Pixabay (
    val totalHits:Int,
    val hits:Array<PhotoItem>,
    val total:Int
        )

@Parcelize data class PhotoItem(
    @SerializedName("webformatURL") val previewURL:String,
    @SerializedName("id") val photoId:Int,
    @SerializedName("largeImageURL") val fullURL:String,
    @SerializedName("pageURL") val pageURL:String
):Parcelable