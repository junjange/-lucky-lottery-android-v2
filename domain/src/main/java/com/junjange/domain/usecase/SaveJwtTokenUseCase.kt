package com.junjange.domain.usecase

import com.junjange.domain.model.JwtToken
import com.junjange.domain.repository.LocalRepository
import javax.inject.Inject

class SaveJwtTokenUseCase
    @Inject
    constructor(
        private val repository: LocalRepository,
    ) {
        suspend operator fun invoke(jwtToken: JwtToken) = repository.saveJwtToken(jwtToken = jwtToken)
    }
