package com.nikhilproject.common.model

data class FootballClubRemote(
    val name: String,
    val image: Int,
    val playerDetail: List<PlayerDetailRemote>
)