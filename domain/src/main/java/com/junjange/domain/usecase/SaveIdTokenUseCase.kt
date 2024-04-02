package com.junjange.domain.usecase

import com.junjange.domain.repository.LocalRepository
import javax.inject.Inject

class SaveIdTokenUseCase
    @Inject
    constructor(
        private val repository: LocalRepository,
    ) {
        suspend operator fun invoke(idToken: String) = repository.saveIdToken(idToken = idToken)
    }
