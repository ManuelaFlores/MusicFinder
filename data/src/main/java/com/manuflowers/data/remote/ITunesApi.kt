package com.manuflowers.data.remote

import com.manuflowers.data.repository.search.model.TracksResultData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApi {
    @GET("search")
    suspend fun getSearchResult(
        @Query("term") query: String,
        @Query("mediaType") mediaType: String,
        @Query("limit") limit: String
    ): Response<TracksResultData>
}