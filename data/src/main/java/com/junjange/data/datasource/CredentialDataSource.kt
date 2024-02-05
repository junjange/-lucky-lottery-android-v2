package com.junjange.data.datasource

import com.junjange.data.model.local.JwtTokenEntity
import com.junjange.data.model.remote.AccessTokenEntity
import com.junjange.data.model.remote.IsRegisteredEntity

interface CredentialDataSource {

    suspend fun postSignup2(nickName: String): Result<Unit>

    suspend fun postRegister(
        idToken: String,
        provider: String,
        nickName: String,
    ): Result<JwtTokenEntity>

    suspend fun postLogin(
        idToken: String,
        provider: String,
    ): Result<JwtTokenEntity>

    suspend fun postLogin2(userId: String): Result<AccessTokenEntity>

    suspend fun getValidRegister(
        idToken: String,
        provider: String,
    ): Result<IsRegisteredEntity>
}