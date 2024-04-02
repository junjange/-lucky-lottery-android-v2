package com.junjange.domain.usecase

import com.junjange.domain.model.JwtToken
import com.junjange.domain.repository.CredentialRepository
import javax.inject.Inject

class PostLoginUseCase
    @Inject
    constructor(
        private val repository: CredentialRepository,
    ) {
        suspend operator fun invoke(
            idToken: String,
            provider: String,
        ): Result<JwtToken> =
            repository.postLogin(
                idToken = idToken,
                provider = provider,
            )
    }
