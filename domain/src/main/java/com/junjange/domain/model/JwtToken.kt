package com.junjange.domain.model

data class JwtToken(
    val accessToken: String?,
    val refreshToken: String?,
)