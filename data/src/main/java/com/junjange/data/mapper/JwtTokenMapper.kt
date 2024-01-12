package com.junjange.data.mapper

import com.junjange.data.model.local.JwtTokenEntity
import com.junjange.domain.model.JwtToken

internal fun JwtTokenEntity.toDomain(): JwtToken {
    return JwtToken(
        accessToken = this.accessToken,
        refreshToken = this.refreshToken
    )
}

internal fun JwtToken.toData(): JwtTokenEntity {
    return JwtTokenEntity(
        accessToken = this.accessToken,
        refreshToken = this.refreshToken
    )
}