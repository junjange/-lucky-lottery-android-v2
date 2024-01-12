package com.junjange.domain.repository

interface FirebaseRepository {
    suspend fun getToken(): Result<String>
}