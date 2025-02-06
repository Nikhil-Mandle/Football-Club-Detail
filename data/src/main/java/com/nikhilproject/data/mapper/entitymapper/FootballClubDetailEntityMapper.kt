package com.nikhilproject.data.mapper.entitymapper

import com.nikhilproject.data.entities.FootballClubEntity
import com.nikhilproject.domain.model.FootballClub

object FootballClubDetailEntityMapper : BaseEntityMapper<FootballClubEntity, FootballClub> {
    override fun mapFromEntity(remoteObject: FootballClubEntity): FootballClub {
        return FootballClub(
            name = remoteObject.name,
            image = remoteObject.image,
            playerDetails = remoteObject.playerDetail.map { playerEntity ->
                PlayerDetailEntityMapper.mapFromEntity(playerEntity)
            }
        )
    }
}