package com.junjange.data.datasource

import com.junjange.data.model.remote.GoogleOauthTokenEntity

interface GoogleDataSource {
    suspend fun postOauthToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        redirectUri: String,
        code: String,
    ): Result<GoogleOauthTokenEntity>
}
