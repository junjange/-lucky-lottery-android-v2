package com.junjange.remote.api

import com.junjange.remote.model.BaseResponse
import com.junjange.remote.model.request.LotteryRandomRequest
import com.junjange.remote.model.request.PensionLotteryRandomRequest
import com.junjange.remote.model.request.RefreshRequest
import com.junjange.remote.model.request.RegisterRequest
import com.junjange.remote.model.response.IsRegisteredResponse
import com.junjange.remote.model.response.JwtTokenResponse
import com.junjange.remote.model.response.LotteryNumbersResponse
import com.junjange.remote.model.response.LotteryGetResponse
import com.junjange.remote.model.response.LotteryRandomNumbersResponse
import com.junjange.remote.model.response.PensionLotteryGetResponse
import com.junjange.remote.model.response.PensionLotteryHomeResponse
import com.junjange.remote.model.response.PensionLotteryRandomResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


internal interface ApiService {

    @POST(ApiClient.Credentials.postCredentialsRegister)
    suspend fun postRegister(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
        @Body body: RegisterRequest,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.Credentials.postCredentialsRefresh)
    suspend fun postRefresh(
        @Body body: RefreshRequest,
    ): BaseResponse<JwtTokenResponse>

    @POST(ApiClient.Credentials.postCredentialsLogin)
    suspend fun postLogin(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
    ): BaseResponse<JwtTokenResponse>

    @GET(ApiClient.Credentials.getCredentialsValidRegister)
    suspend fun getValidRegister(
        @Query("idToken") idToken: String,
        @Query("provider") provider: String,
    ): BaseResponse<IsRegisteredResponse>

    @POST(ApiClient.Lottery.postLotterySave)
    suspend fun postLotterySave(
        @Body body: LotteryRandomRequest,
    ): BaseResponse<Unit>

    @GET(ApiClient.Lottery.getLotteryRandom)
    suspend fun getLotteryRandom(): BaseResponse<LotteryRandomNumbersResponse>

    @GET(ApiClient.Lottery.getLotteryGet)
    suspend fun getLotteryGet(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): BaseResponse<LotteryGetResponse>

    @POST(ApiClient.PensionLottery.postPensionLotterySave)
    suspend fun postPensionLotterySave(@Body body: PensionLotteryRandomRequest): BaseResponse<Unit>

    @GET(ApiClient.PensionLottery.getPensionLotteryRandom)
    suspend fun getPensionLotteryRandom(): BaseResponse<PensionLotteryRandomResponse>

    @GET(ApiClient.PensionLottery.getPensionLotteryGet)
    suspend fun getPensionLotteryGet(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): BaseResponse<PensionLotteryGetResponse>

    @GET(ApiClient.PensionLottery.getPensionLotteryHome)
    suspend fun getPensionLotteryHome(): BaseResponse<PensionLotteryHomeResponse>
}
