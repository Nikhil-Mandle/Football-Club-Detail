package com.nikhilproject.common.mapper

interface BaseRemoteMapper<in REMOTE, out ENTITY> {
    fun mapFromRemote(remoteObject:REMOTE):ENTITY
}