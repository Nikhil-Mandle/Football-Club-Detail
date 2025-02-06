package com.nikhilproject.presentation.di

import com.nikhilproject.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module


val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}