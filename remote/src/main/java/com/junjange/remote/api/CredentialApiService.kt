package com.junjange.remote.api

import com.junjange.remote.model.BaseResponse
import com.junjange.remote.model.request.RefreshRequest
import com.junjange.remote.model.request.RegisterRequest
import com.junjange.remote.model.response.AccessTokenResponse
import com.junjange.remote.model.response.IsRegisteredResponse
import com.junjange.remote.model.response.JwtTokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


internal interface CredentialApiService {

    @POST(ApiClient.CREDENTIALS.postCredentialsSignup2)
    suspend fun postSignup2(
        @Body body: RegisterRequest,
    ): BaseResponse<Unit>

    @POST(ApiClient.CREDENTIALS.postCredentialsRegister)
    suspend fun postRegister(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
        @Body body: RegisterRequest,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.CREDENTIALS.postCredentialsRefresh)
    suspend fun postRefresh(
        @Body body: RefreshRequest,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.CREDENTIALS.postCredentialsLogin)
    suspend fun postLogin(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.CREDENTIALS.postCredentialsLogin2)
    suspend fun postLogin2(
        @Query("userId") userId: String,
    ): BaseResponse<AccessTokenResponse>

    @GET(ApiClient.CREDENTIALS.postCredentialsValidRegister)
    suspend fun getValidRegister(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
    ): BaseResponse<IsRegisteredResponse>

}
