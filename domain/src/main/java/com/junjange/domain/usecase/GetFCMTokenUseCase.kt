package com.junjange.domain.usecase

import com.junjange.domain.repository.FirebaseRepository
import javax.inject.Inject

class GetFCMTokenUseCase @Inject constructor(
    private val repository: FirebaseRepository
) {
    suspend operator fun invoke(): Result<String> = repository.getToken()
}