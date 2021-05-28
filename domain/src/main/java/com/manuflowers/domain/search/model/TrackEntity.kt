package com.manuflowers.domain.search.model

data class TrackEntity(
    val wrapperType: String,
    val kind: String,
    val collectionId: Long,
    val trackId: Long,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionCensoredName: String,
    val trackCensoredName: String,
    val previewUrl: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val collectionPrice: Double,
    val trackPrice: Double,
    val collectionHdPrice: Double,
    val trackHdPrice: Double,
    val releaseDate: String,
    val trackTimeMillis: Long,
    val country: String,
    val currency: CurrencyType,
    val primaryGenreName: String,
    val longDescription: String,
    val artistViewUrl: String
)