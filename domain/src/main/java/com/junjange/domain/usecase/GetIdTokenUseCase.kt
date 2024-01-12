package com.junjange.domain.usecase

import com.junjange.domain.repository.LocalRepository
import javax.inject.Inject

class GetIdTokenUseCase @Inject constructor(
    private val repository: LocalRepository,
) {
    suspend operator fun invoke(): Result<String?> = repository.getIdToken()
}