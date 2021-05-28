package com.manuflowers.domain.search.repository

import com.manuflowers.domain.search.model.TrackEntity
import com.manuflowers.domain.utils.Result

interface SearchRepository {
    suspend fun getSearchResult(
        query: String,
        mediaType: String,
        limit: String
    ): Result<List<TrackEntity>>
}