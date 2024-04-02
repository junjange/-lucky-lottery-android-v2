package com.junjange.domain.repository

import com.junjange.domain.model.GoogleOauthToken

interface GoogleRepository {
    suspend fun postOauthToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        redirectUri: String,
        code: String,
    ): Result<GoogleOauthToken>
}
