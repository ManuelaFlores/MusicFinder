package com.manuflowers.data.repository.search.model

import com.manuflowers.domain.search.model.CurrencyType
import com.manuflowers.domain.search.model.TrackEntity

fun TracksResultData.toDomain(): List<TrackEntity> {
    return this.results.map {
        TrackEntity(
            wrapperType = it.wrapperType ?: "",
            kind = it.kind ?: "",
            collectionId = it.collectionId ?: 0L,
            trackId = it.trackId ?: 0L,
            artistName = it.artistName ?: "",
            collectionName = it.collectionName ?: "",
            trackName = it.trackName ?: "",
            collectionCensoredName = it.collectionCensoredName ?: "",
            trackCensoredName = it.trackCensoredName ?: "",
            previewUrl = it.previewUrl ?: "",
            artworkUrl60 = it.artworkUrl60 ?: "",
            artworkUrl100 = it.artworkUrl100 ?: "",
            collectionHdPrice = it.collectionHdPrice ?: 0.0,
            trackHdPrice = it.trackHdPrice ?: 0.0,
            collectionPrice = it.collectionPrice ?: 0.0,
            trackPrice = it.trackPrice ?: 0.0,
            releaseDate = it.releaseDate ?: "",
            trackTimeMillis = it.trackTimeMillis ?: 0L,
            country = it.country ?: "",
            currency = CurrencyType.valueOf(it.currency ?: "USD"),
            primaryGenreName = it.primaryGenreName ?: "",
            longDescription = it.longDescription ?: "",
            artistViewUrl = it.artistViewUrl ?: ""
        )
    }
}