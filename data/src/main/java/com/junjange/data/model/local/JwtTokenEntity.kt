package com.junjange.data.model.local

data class JwtTokenEntity(
    val accessToken: String?,
    val refreshToken: String?,
)
