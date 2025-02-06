package com.nikhilproject.data.repository

import com.nikhilproject.data.SafeApiCall
import com.nikhilproject.data.datasource.remote.FootballClubRemoteDataSource
import com.nikhilproject.data.mapper.entitymapper.FootballClubEntityMapper
import com.nikhilproject.domain.common.Result
import com.nikhilproject.domain.model.FootballClubData
import com.nikhilproject.domain.repository.FootballClubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class FootballClubRepositoryImpl(
    private val footballClubRemoteDataSource: FootballClubRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : FootballClubRepository {

    override suspend fun getFootballClub(): Result<FootballClubData> = SafeApiCall.execute(
        dispatcher = dispatcher,
        apiCall = { FootballClubEntityMapper.mapFromEntity(footballClubRemoteDataSource.fetchFootballClubDetails()) }
    )
}