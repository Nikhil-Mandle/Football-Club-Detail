package com.nikhilproject.common.mapper

import com.nikhilproject.common.model.FootballClubDataRemote
import com.nikhilproject.data.entities.FootballClubDataEntity

object FootballClubDataRemoteMapper :
    BaseRemoteMapper<FootballClubDataRemote, FootballClubDataEntity> {
    override fun mapFromRemote(remoteObject: FootballClubDataRemote): FootballClubDataEntity {
        return FootballClubDataEntity(
            footballClub = remoteObject.footballClubRemote.map { footballClubRemote ->
                FootballClubRemoteMapper.mapFromRemote(footballClubRemote)
            }
        )
    }
}