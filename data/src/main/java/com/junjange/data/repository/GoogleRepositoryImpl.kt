package com.junjange.data.repository

import com.junjange.data.datasource.GoogleDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.GoogleOauthToken
import com.junjange.domain.repository.GoogleRepository
import javax.inject.Inject

internal class GoogleRepositoryImpl
    @Inject
    constructor(
        private val dataSource: GoogleDataSource,
    ) : GoogleRepository {
        override suspend fun postOauthToken(
            grantType: String,
            clientId: String,
            clientSecret: String,
            redirectUri: String,
            code: String,
        ): Result<GoogleOauthToken> =
            dataSource.postOauthToken(
                grantType = grantType,
                clientId = clientId,
                clientSecret = clientSecret,
                redirectUri = redirectUri,
                code = code,
            ).mapCatching { it.toDomain() }
    }
