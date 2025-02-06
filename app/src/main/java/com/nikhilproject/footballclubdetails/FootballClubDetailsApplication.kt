package com.nikhilproject.footballclubdetails

import android.app.Application
import com.nikhilproject.common.di.remoteModule
import com.nikhilproject.data.di.dataModule
import com.nikhilproject.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FootballClubDetailsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FootballClubDetailsApplication)
            modules(
                viewModelModule,
                dataModule,
                remoteModule
            )
        }
    }
}