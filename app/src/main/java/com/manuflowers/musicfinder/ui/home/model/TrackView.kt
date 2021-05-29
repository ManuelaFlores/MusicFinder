package com.manuflowers.musicfinder.ui.home.model

data class TrackView(
    val trackId: Long,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val trackImage: String,
    val previewUrl: String,
    val trackReleasedDate: String,
    val trackDuration: String
)