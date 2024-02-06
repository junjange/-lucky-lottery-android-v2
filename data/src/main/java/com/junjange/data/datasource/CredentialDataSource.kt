package com.junjange.data.datasource

import com.junjange.data.model.local.JwtTokenEntity
import com.junjange.data.model.remote.IsRegisteredEntity

interface CredentialDataSource {

    suspend fun postRegister(
        idToken: String,
        provider: String,
        nickName: String,
    ): Result<JwtTokenEntity>

    suspend fun postLogin(
        idToken: String,
        provider: String,
    ): Result<JwtTokenEntity>

    suspend fun getValidRegister(
        idToken: String,
        provider: String,
    ): Result<IsRegisteredEntity>
}