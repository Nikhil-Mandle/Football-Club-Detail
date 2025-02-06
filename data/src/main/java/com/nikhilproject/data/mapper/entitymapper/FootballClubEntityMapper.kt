package com.nikhilproject.data.mapper.entitymapper

import com.nikhilproject.data.entities.FootballClubDataEntity
import com.nikhilproject.domain.model.FootballClubData

object FootballClubEntityMapper :
    BaseEntityMapper<FootballClubDataEntity, FootballClubData> {
    override fun mapFromEntity(remoteObject: FootballClubDataEntity): FootballClubData {
        return FootballClubData(
            footballClubs = remoteObject.footballClub.map { footballClubRemote ->
                FootballClubDetailEntityMapper.mapFromEntity(footballClubRemote)
            }
        )
    }
}