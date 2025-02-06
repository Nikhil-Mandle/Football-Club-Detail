package com.nikhilproject.common.service

import com.nikhilproject.common.data.FootballClubDataData


class ApiService {

    suspend fun fetchRemoteFootbalClub() = FootballClubDataData.footballClubRemoteData
    
}