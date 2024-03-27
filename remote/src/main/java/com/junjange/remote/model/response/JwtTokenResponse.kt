package com.junjange.remote.model.response

import com.junjange.data.model.local.JwtTokenEntity

data class JwtTokenResponse(
    val accessToken: String,
    val refreshToken: String,
)

internal fun JwtTokenResponse.toData(): JwtTokenEntity =
    JwtTokenEntity(
        accessToken = accessToken,
        refreshToken = refreshToken,
    )
