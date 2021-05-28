package com.manuflowers.data.di

import com.manuflowers.data.remote.ITunesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { buildClient() }

    single { buildRetrofit(get()) }

    single { buildITunesApi() }
}

private const val BASE_URL = "https://itunes.apple.com/"

private fun buildITunesApi(): ITunesApi = buildRetrofit(buildClient()).create(ITunesApi::class.java)

private fun buildRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .build()
}

private fun buildClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}