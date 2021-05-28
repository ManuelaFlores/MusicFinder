package com.manuflowers.data.repository.search.model

import com.manuflowers.domain.search.model.CurrencyType
import com.manuflowers.domain.search.model.TrackEntity

fun TracksResultData.toDomain(): List<TrackEntity> {
    return this.results.map {
        TrackEntity(
            wrapperType = it.wrapperType,
            kind = it.kind,
            collectionId = it.collectionId,
            trackId = it.trackId,
            artistName = it.artistName,
            collectionName = it.collectionName,
            trackName = it.trackName,
            collectionCensoredName = it.collectionCensoredName,
            trackCensoredName = it.trackCensoredName,
            previewUrl = it.previewUrl,
            artworkUrl60 = it.artworkUrl60,
            artworkUrl100 = it.artworkUrl100,
            collectionHdPrice = it.collectionHdPrice,
            trackHdPrice = it.trackHdPrice,
            collectionPrice = it.collectionPrice,
            trackPrice = it.trackPrice,
            releaseDate = it.releaseDate,
            trackTimeMillis = it.trackTimeMillis,
            country = it.country,
            currency = CurrencyType.valueOf(it.currency),
            primaryGenreName = it.primaryGenreName,
            longDescription = it.longDescription,
            artistViewUrl = it.artistViewUrl
        )
    }
}