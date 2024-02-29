package com.junjange.domain.usecase

import com.junjange.domain.repository.UserRepository
import javax.inject.Inject

class PatchUserProfileUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(profilePath: String): Result<Unit> =
        repository.patchUserProfile(profilePath = profilePath)
}