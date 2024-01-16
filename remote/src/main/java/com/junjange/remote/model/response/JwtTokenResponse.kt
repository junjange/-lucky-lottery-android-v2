package com.junjange.remote.model.response


data class JwtTokenResponse(
    val accessToken: String,
    val refreshToken: String,
)
