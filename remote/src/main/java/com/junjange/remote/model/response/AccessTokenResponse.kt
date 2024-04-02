package com.junjange.remote.model.response

import com.junjange.data.model.remote.AccessTokenEntity

data class AccessTokenResponse(
    val accessToken: String,
)

fun AccessTokenResponse.toData() = AccessTokenEntity(accessToken = accessToken)
