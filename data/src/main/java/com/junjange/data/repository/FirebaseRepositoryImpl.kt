package com.junjange.data.repository

import com.junjange.data.datasource.FirebaseDataSource
import com.junjange.domain.repository.FirebaseRepository
import javax.inject.Inject

internal class FirebaseRepositoryImpl
    @Inject
    constructor(
        private val firebaseDataSource: FirebaseDataSource,
    ) : FirebaseRepository {
        override suspend fun getToken(): Result<String> = firebaseDataSource.getToken().mapCatching { it }
    }
