package com.junjange.data.mapper

import com.junjange.data.model.remote.GoogleOauthTokenEntity
import com.junjange.domain.model.GoogleOauthToken

internal fun GoogleOauthTokenEntity.toDomain(): GoogleOauthToken {
    return GoogleOauthToken(
        accessToken = accessToken,
        expiresIn = expiresIn,
        scope = scope,
        tokenType = tokenType,
        idToken = idToken,
    )
}
