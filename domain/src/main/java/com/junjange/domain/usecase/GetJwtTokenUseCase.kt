package com.junjange.domain.usecase

import com.junjange.domain.model.JwtToken
import com.junjange.domain.repository.LocalRepository
import javax.inject.Inject

class GetJwtTokenUseCase
    @Inject
    constructor(
        private val repository: LocalRepository,
    ) {
        suspend operator fun invoke(): Result<JwtToken?> = repository.getJwtToken()
    }
