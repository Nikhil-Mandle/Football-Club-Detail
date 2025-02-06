package com.nikhilproject.common.mapper

import com.nikhilproject.common.model.FootballClubRemote
import com.nikhilproject.data.entities.FootballClubEntity

object FootballClubRemoteMapper : BaseRemoteMapper<FootballClubRemote, FootballClubEntity> {
    override fun mapFromRemote(remoteObject: FootballClubRemote): FootballClubEntity {
       return FootballClubEntity(
            name = remoteObject.name,
            image = remoteObject.image,
            playerDetail = remoteObject.playerDetail.map { playerRemote ->
                PlayerDetailRemoteMapper.mapFromRemote(playerRemote)
            }
        )
    }
}