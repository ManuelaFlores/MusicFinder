package com.manuflowers.domain.di

import com.manuflowers.domain.search.GetSearchResultUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetSearchResultUseCase(get()) }
}