package com.nikhilproject.common.mapper

import com.nikhilproject.common.model.PlayerDetailRemote
import com.nikhilproject.data.entities.PlayerDetailEntity

object PlayerDetailRemoteMapper : BaseRemoteMapper<PlayerDetailRemote, PlayerDetailEntity> {
    override fun mapFromRemote(remoteObject: PlayerDetailRemote): PlayerDetailEntity {
        return  PlayerDetailEntity(
            name = remoteObject.name,
            description = remoteObject.position,
            image = remoteObject.image
        )
    }
}