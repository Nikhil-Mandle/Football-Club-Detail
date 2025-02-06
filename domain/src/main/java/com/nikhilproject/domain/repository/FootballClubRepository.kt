package com.nikhilproject.domain.repository

import com.nikhilproject.domain.common.Result
import com.nikhilproject.domain.model.FootballClubData

interface FootballClubRepository {
    suspend fun getFootballClub(): Result<FootballClubData>
}