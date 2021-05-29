package com.manuflowers.musicfinder.ui.home.model

import com.manuflowers.domain.search.model.TrackEntity

fun TrackEntity.toView(): TrackView {
    return TrackView(
        trackId = this.trackId,
        artistName = this.artistName,
        collectionName = this.collectionName,
        trackName = this.trackName,
        trackImage = this.artworkUrl100,
        previewUrl = this.previewUrl,
        trackReleasedDate = "",
        trackDuration = this.parsedTrackDuration,
    )
}