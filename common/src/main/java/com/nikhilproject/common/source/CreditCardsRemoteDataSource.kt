package com.nikhilproject.common.source

import com.nikhilproject.data.datasource.remote.FootballClubRemoteDataSource
import com.nikhilproject.common.mapper.FootballClubDataRemoteMapper
import com.nikhilproject.common.service.ApiService
import com.nikhilproject.data.entities.FootballClubDataEntity


class FootballClubRemoteDataSourceImpl(
    private val apiService: ApiService,
) : FootballClubRemoteDataSource {
    override suspend fun fetchFootballClubDetails(): FootballClubDataEntity =
        FootballClubDataRemoteMapper.mapFromRemote(apiService.fetchRemoteFootbalClub())
}