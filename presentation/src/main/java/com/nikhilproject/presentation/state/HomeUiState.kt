package com.nikhilproject.presentation.state

import androidx.annotation.StringRes
import com.nikhilproject.domain.model.FootballClub

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val cardList: List<FootballClub>? = null,
        val carouselImages: List<Int>? = null
    ) : HomeUiState

    data class Error(
        val stringMessage: String? = null,
        @StringRes val resourceId: Int? = null
    ) : HomeUiState

    data object Nothing : HomeUiState
}