package com.manuflowers.data.repository.search.model

import com.squareup.moshi.Json

data class TrackData(
    @field:Json(name = "wrapperType")
    val wrapperType: String?,
    @field:Json(name = "kind")
    val kind: String?,
    @field:Json(name = "collectionId")
    val collectionId: Long?,
    @field:Json(name = "trackId")
    val trackId: Long?,
    @field:Json(name = "artistName")
    val artistName: String?,
    @field:Json(name = "collectionName")
    val collectionName: String?,
    @field:Json(name = "trackName")
    val trackName: String?,
    @field:Json(name = "collectionCensoredName")
    val collectionCensoredName: String?,
    @field:Json(name = "trackCensoredName")
    val trackCensoredName: String?,
    @field:Json(name = "previewUrl")
    val previewUrl: String?,
    @field:Json(name = "artworkUrl60")
    val artworkUrl60: String?,
    @field:Json(name = "artworkUrl100")
    val artworkUrl100: String?,
    @field:Json(name = "collectionPrice")
    val collectionPrice: Double?,
    @field:Json(name = "trackPrice")
    val trackPrice: Double?,
    @field:Json(name = "collectionHdPrice")
    val collectionHdPrice: Double?,
    @field:Json(name = "trackHdPrice")
    val trackHdPrice: Double?,
    @field:Json(name = "releaseDate")
    val releaseDate: String?,
    @field:Json(name = "trackTimeMillis")
    val trackTimeMillis: Long?,
    @field:Json(name = "country")
    val country: String?,
    @field:Json(name = "currency")
    val currency: String?,
    @field:Json(name = "primaryGenreName")
    val primaryGenreName: String?,
    @field:Json(name = "longDescription")
    val longDescription: String?,
    @field:Json(name = "artistViewUrl")
    val artistViewUrl: String?
)