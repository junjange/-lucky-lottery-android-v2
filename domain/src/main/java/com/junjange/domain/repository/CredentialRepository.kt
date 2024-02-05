package com.junjange.domain.repository

import com.junjange.domain.model.AccessToken
import com.junjange.domain.model.IsRegistered
import com.junjange.domain.model.JwtToken

interface CredentialRepository {
    suspend fun postSignup2(nickName: String): Result<Unit>

    suspend fun postRegister(
        idToken: String,
        provider: String,
        nickName: String,
    ): Result<JwtToken>

    suspend fun postLogin(
        idToken: String,
        provider: String,
    ): Result<JwtToken>

    suspend fun postLogin2(userId: String): Result<AccessToken>

    suspend fun getValidRegister(
        idToken: String,
        provider: String,
    ): Result<IsRegistered>
}