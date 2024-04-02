package com.junjange.domain.usecase

import com.junjange.domain.repository.CredentialRepository
import javax.inject.Inject

class PostLogoutUseCase
    @Inject
    constructor(
        private val repository: CredentialRepository,
    ) {
        suspend operator fun invoke(): Result<Unit> = repository.postLogout()
    }
