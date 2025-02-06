package com.nikhilproject.data.datasource.remote

import com.nikhilproject.data.entities.FootballClubDataEntity

interface FootballClubRemoteDataSource {
    suspend fun fetchFootballClubDetails(): FootballClubDataEntity
}