package com.junjange.domain.usecase

import com.junjange.domain.model.JwtToken
import com.junjange.domain.repository.CredentialRepository
import javax.inject.Inject

class PostRegisterUseCase @Inject constructor(
    private val repository: CredentialRepository
) {
    suspend operator fun invoke(
        idToken: String,
        provider: String,
        nickName: String
    ): Result<JwtToken> =
        repository.postRegister(
            idToken = idToken,
            provider = provider,
            nickName = nickName
        )
}