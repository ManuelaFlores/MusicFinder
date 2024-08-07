package com.manuflowers.musicfinder.application

import android.app.Application
import com.manuflowers.data.di.networkModule
import com.manuflowers.data.di.repositoryModule
import com.manuflowers.domain.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MusicFinderApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MusicFinderApplication)
            modules(dataModules + domainModules + presentationModule)
        }
    }
}

val presentationModule = listOf(com.manuflowers.musicfinder.di.presentationModule)
val dataModules = listOf(networkModule, repositoryModule)
val domainModules = listOf(useCasesModule)