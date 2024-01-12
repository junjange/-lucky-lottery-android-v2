package com.junjange.domain.usecase

import com.junjange.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteLocalDataUseCase @Inject constructor(
    private val repository: LocalRepository,
) {
    suspend operator fun invoke(): Result<Unit> = repository.deleteLocalData()
}