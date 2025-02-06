package com.nikhilproject.data.mapper.entitymapper

import com.nikhilproject.data.entities.PlayerDetailEntity
import com.nikhilproject.domain.model.PlayerDetail

object PlayerDetailEntityMapper : BaseEntityMapper<PlayerDetailEntity, PlayerDetail> {
    override fun mapFromEntity(remoteObject: PlayerDetailEntity): PlayerDetail {
        return PlayerDetail(
            name = remoteObject.name,
            description = remoteObject.description,
            image = remoteObject.image
        )
    }
}