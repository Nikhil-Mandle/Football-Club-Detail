package com.nikhilproject.presentation.mapper

import com.nikhilproject.domain.common.Result
import com.nikhilproject.domain.model.FootballClubData
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.state.HomeUiState

object ResultMapper {
    fun <T> homeStateErrorMapper(resultState: Result.ErrorState<T>): HomeUiState.Error {
        return when {
            resultState.message != null -> HomeUiState.Error(resourceId = resultState.message)
            resultState.responseMessage != null -> HomeUiState.Error(stringMessage = resultState.responseMessage)
            else -> {
                HomeUiState.Error(resourceId = R.string.generic_error)
            }
        }
    }

    fun homeStateSuccessMapper(resultState: Result.SuccessState<FootballClubData>) =
        HomeUiState.Success(
            footballClubCardList = resultState.data.footballClubs,
            carouselImages = resultState.data.footballClubs.map { it.image },
        )
}
