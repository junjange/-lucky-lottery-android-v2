package com.junjange.firebase.datasource

import com.junjange.data.datasource.GoogleDataSource
import com.junjange.data.model.remote.GoogleOauthTokenEntity
import com.junjange.firebase.api.GoogleApiService
import com.junjange.firebase.model.request.GoogleOauthTokenRequest
import com.junjange.firebase.model.response.toData
import javax.inject.Inject

internal class GoogleDataSourceImpl
    @Inject
    constructor(
        private val apiService: GoogleApiService,
    ) : GoogleDataSource {
        override suspend fun postOauthToken(
            grantType: String,
            clientId: String,
            clientSecret: String,
            redirectUri: String,
            code: String,
        ): Result<GoogleOauthTokenEntity> =
            runCatching {
                val body =
                    GoogleOauthTokenRequest(
                        grantType = grantType,
                        clientId = clientId,
                        clientSecret = clientSecret,
                        redirectUri = redirectUri,
                        code = code,
                    )
                apiService.postOauthToken(
                    body = body,
                ).toData()
            }
    }
