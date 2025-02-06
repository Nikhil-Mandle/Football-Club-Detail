package com.nikhilproject.common.di

import com.nikhilproject.data.datasource.remote.FootballClubRemoteDataSource
import com.nikhilproject.common.service.ApiService
import com.nikhilproject.common.source.FootballClubRemoteDataSourceImpl

import org.koin.dsl.module

val remoteModule = module {
    single<FootballClubRemoteDataSource> { FootballClubRemoteDataSourceImpl(get())  }

    single { ApiService()  }
}