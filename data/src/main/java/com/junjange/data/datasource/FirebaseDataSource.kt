package com.junjange.data.datasource


interface FirebaseDataSource {
    suspend fun getToken(): Result<String>
}