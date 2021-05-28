package com.manuflowers.domain.search

import com.manuflowers.domain.search.model.TrackEntity
import com.manuflowers.domain.search.repository.SearchRepository
import com.manuflowers.domain.utils.Result

class GetSearchResultUseCase(
    private val searchRepository: SearchRepository
) {
    suspend fun getSearchResult(
        query: String,
        mediaType: String,
        limit: String
    ): Result<List<TrackEntity>> {
        return searchRepository.getSearchResult(query, mediaType, limit)
    }
}