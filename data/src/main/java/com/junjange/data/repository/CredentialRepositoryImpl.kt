package com.junjange.data.repository

import com.junjange.data.datasource.CredentialDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.IsRegistered
import com.junjange.domain.model.JwtToken
import com.junjange.domain.repository.CredentialRepository
import javax.inject.Inject

internal class CredentialRepositoryImpl @Inject constructor(
    private val dataSource: CredentialDataSource
) : CredentialRepository {

    override suspend fun postRegister(
        idToken: String,
        provider: String,
        nickName: String,
    ): Result<JwtToken> = dataSource.postRegister(
        idToken = idToken,
        provider = provider,
        nickName = nickName,
    ).mapCatching { it.toDomain() }


    override suspend fun postLogin(
        idToken: String,
        provider: String,
    ): Result<JwtToken> = dataSource.postLogin(
        idToken = idToken,
        provider = provider
    ).mapCatching { it.toDomain() }

    override suspend fun getValidRegister(
        idToken: String,
        provider: String,
    ): Result<IsRegistered> =
        dataSource.getValidRegister(
            idToken = idToken,
            provider = provider
        ).mapCatching { it.toDomain() }


}