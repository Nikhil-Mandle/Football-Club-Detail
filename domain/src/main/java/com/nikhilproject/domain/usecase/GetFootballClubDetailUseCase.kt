package com.nikhilproject.domain.usecase

import com.nikhilproject.domain.common.FlowResult
import com.nikhilproject.domain.model.FootballClubData
import com.nikhilproject.domain.repository.FootballClubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class GetFootballClubDetailUseCase(
    private val footballClubRepository: FootballClubRepository
) {
    operator fun invoke(): FlowResult<FootballClubData> = flow {
        val result = footballClubRepository.getFootballClub()
        emit(result)
    }.flowOn(Dispatchers.IO)
}