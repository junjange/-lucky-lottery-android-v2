package com.junjange.remote.api

import com.junjange.remote.model.response.RefreshResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RefreshApiService {

    @GET("user/refresh")
    suspend fun refresh(
        @Query("refresh_token") refreshToken: String,
    ): RefreshResponse
}
