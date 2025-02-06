package com.nikhilproject.data.entities

data class FootballClubEntity(
    val name: String,
    val image: Int,
    val playerDetail: List<PlayerDetailEntity>
)
