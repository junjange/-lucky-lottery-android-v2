package com.junjange.domain.repository

import com.junjange.domain.model.JwtToken

interface LocalRepository {
    suspend fun getJwtToken(): Result<JwtToken?>

    suspend fun getIdToken(): Result<String?>

    suspend fun deleteLocalData(): Result<Unit>

    suspend fun saveJwtToken(jwtToken: JwtToken): Result<Unit>

    suspend fun saveIdToken(idToken: String): Result<Unit>
}