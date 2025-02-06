package com.nikhilproject.data.di

import com.nikhilproject.domain.repository.FootballClubRepository
import com.nikhilproject.domain.usecase.GetFootballClubDetailUseCase
import com.nikhilproject.data.repository.FootballClubRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


val dataModule = module {

    single { Dispatchers.IO }

    single<FootballClubRepository> { FootballClubRepositoryImpl(get(), get()) }

    single { GetFootballClubDetailUseCase(get()) }
}