package com.junjange.domain.repository

import com.junjange.domain.model.IsRegistered
import com.junjange.domain.model.JwtToken

interface CredentialRepository {
    suspend fun postRegister(
        idToken: String,
        provider: String,
        nickName: String,
    ): Result<JwtToken>

    suspend fun postLogin(
        idToken: String,
        provider: String,
    ): Result<JwtToken>

    suspend fun getValidRegister(
        idToken: String,
        provider: String,
    ): Result<IsRegistered>
}
