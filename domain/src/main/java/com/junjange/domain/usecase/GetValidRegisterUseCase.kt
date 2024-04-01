package com.junjange.domain.usecase

import com.junjange.domain.model.IsRegistered
import com.junjange.domain.repository.CredentialRepository
import javax.inject.Inject

class GetValidRegisterUseCase
    @Inject
    constructor(
        private val repository: CredentialRepository,
    ) {
        suspend operator fun invoke(
            idToken: String,
            provider: String,
        ): Result<IsRegistered> =
            repository.getValidRegister(
                idToken = idToken,
                provider = provider,
            )
    }
