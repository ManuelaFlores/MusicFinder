package com.manuflowers.data.repository.search.model

import com.squareup.moshi.Json

data class TracksResultData(
    @field:Json(name = "resultCount")
    val resultCount: Int,
    @field:Json(name = "results")
    val results: List<TrackData>
)