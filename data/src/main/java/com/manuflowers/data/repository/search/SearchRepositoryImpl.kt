package com.manuflowers.data.repository.search

import com.manuflowers.data.repository.search.model.toDomain
import com.manuflowers.data.repository.search.sources.remote.SearchDataSource
import com.manuflowers.domain.search.model.TrackEntity
import com.manuflowers.domain.search.repository.SearchRepository
import com.manuflowers.domain.utils.Error
import com.manuflowers.domain.utils.Result
import com.manuflowers.domain.utils.Success

class SearchRepositoryImpl(
    private val searchDataSource: SearchDataSource
) : SearchRepository {
    override suspend fun getSearchResult(
        query: String,
        mediaType: String,
        limit: String
    ): Result<List<TrackEntity>> {
        return when (val result = searchDataSource.getSearchResult(
            query, mediaType, limit
        )) {
            is Success -> {
                Success(result.data.toDomain())
            }
            is Error -> {
                result
            }
        }
    }
}