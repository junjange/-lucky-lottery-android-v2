package com.junjange.data.repository

import com.junjange.data.datasource.LocalDataSource
import com.junjange.data.mapper.toData
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.JwtToken
import com.junjange.domain.repository.LocalRepository
import javax.inject.Inject

internal class LocalRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : LocalRepository {
    override suspend fun getJwtToken(): Result<JwtToken?> =
        localDataSource.getJwtToken().map { it?.toDomain() }

    override suspend fun getIdToken(): Result<String?> = localDataSource.getIdToken()

    override suspend fun deleteLocalData(): Result<Unit> = localDataSource.deleteLocalData()

    override suspend fun saveJwtToken(jwtToken: JwtToken): Result<Unit> =
        localDataSource.saveJwtToken(jwtTokenEntity = jwtToken.toData())

    override suspend fun saveIdToken(idToken: String): Result<Unit> =
        localDataSource.saveIdToken(idToken = idToken)

}