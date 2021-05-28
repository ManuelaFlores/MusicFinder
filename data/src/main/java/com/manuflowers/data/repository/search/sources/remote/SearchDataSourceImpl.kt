package com.manuflowers.data.repository.search.sources.remote

import com.manuflowers.data.remote.ITunesApi
import com.manuflowers.data.repository.search.model.TracksResultData
import com.manuflowers.domain.utils.Error
import com.manuflowers.domain.utils.Result
import com.manuflowers.domain.utils.Success
import com.squareup.moshi.JsonEncodingException
import retrofit2.HttpException

class SearchDataSourceImpl(
    private val remoteApi: ITunesApi
) : SearchDataSource {
    override suspend fun getSearchResult(
        query: String,
        mediaType: String,
        limit: String
    ): Result<TracksResultData> {
        return try {
            val response = remoteApi.getSearchResult(
                query = query,
                mediaType = mediaType,
                limit = limit
            )
            if (response.isSuccessful) {
                Success(response.body()!!)
            } else {
                Error(message = "Ups")
            }

        } catch (e: JsonEncodingException) {
            Error(
                message = e.localizedMessage ?: e.message ?: ""
            )
        } catch (e: HttpException) {
            Error(
                message = e.localizedMessage ?: e.message(),
                internalCode = e.code().toString()
            )
        } catch (e: Exception) {
            Error(
                message = e.localizedMessage ?: e.message ?: ""
            )
        }
    }
}