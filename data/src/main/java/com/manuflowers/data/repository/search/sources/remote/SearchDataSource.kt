package com.manuflowers.data.repository.search.sources.remote

import com.manuflowers.data.repository.search.model.TracksResultData
import com.manuflowers.domain.utils.Result

interface SearchDataSource {
    suspend fun getSearchResult(
        query: String,
        mediaType: String,
        limit: String
    ): Result<TracksResultData>
}