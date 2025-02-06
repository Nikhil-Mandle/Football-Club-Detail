package com.nikhilproject.domain.model

data class FootballClub(
    val name: String,
    val image: Int,
    val playerDetails: List<PlayerDetail>
)
