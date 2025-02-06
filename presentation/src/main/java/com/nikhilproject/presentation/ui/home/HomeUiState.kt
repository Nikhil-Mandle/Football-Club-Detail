package com.nikhilproject.presentation.ui.home

import androidx.annotation.StringRes
import com.nikhilproject.domain.model.FootballClub

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val footballClubList: List<FootballClub>? = null,
        val carouselImages: List<Int>? = null
    ) : HomeUiState

    data class Error(
        val stringMessage: String? = null,
        @StringRes val resourceId: Int? = null
    ) : HomeUiState

    data object Nothing : HomeUiState
}