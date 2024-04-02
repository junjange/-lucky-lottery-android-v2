package com.junjange.domain.usecase

import com.junjange.domain.model.GoogleOauthToken
import com.junjange.domain.repository.GoogleRepository
import javax.inject.Inject

class PostGoogleOauthTokenUseCase
    @Inject
    constructor(
        private val repository: GoogleRepository,
    ) {
        suspend operator fun invoke(
            grantType: String,
            clientId: String,
            clientSecret: String,
            redirectUri: String,
            code: String,
        ): Result<GoogleOauthToken> =
            repository.postOauthToken(
                grantType = grantType,
                clientId = clientId,
                clientSecret = clientSecret,
                redirectUri = redirectUri,
                code = code,
            )
    }
