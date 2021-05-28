package com.manuflowers.data.di

import com.manuflowers.data.repository.search.SearchRepositoryImpl
import com.manuflowers.data.repository.search.sources.remote.SearchDataSource
import com.manuflowers.data.repository.search.sources.remote.SearchDataSourceImpl
import com.manuflowers.domain.search.repository.SearchRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<SearchDataSource> { SearchDataSourceImpl(get()) }
    single<SearchRepository> { SearchRepositoryImpl(get()) }
}