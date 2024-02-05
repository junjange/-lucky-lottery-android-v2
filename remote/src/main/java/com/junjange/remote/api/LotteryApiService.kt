package com.junjange.remote.api

import com.junjange.remote.model.BaseResponse
import com.junjange.remote.model.request.LotteryRandomRequest
import com.junjange.remote.model.request.RefreshRequest
import com.junjange.remote.model.response.LotteryRandomResponse
import com.junjange.remote.model.response.LotteryResultResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


internal interface LotteryApiService {

    @POST(ApiClient.Lottery.postLotterySave)
    suspend fun postLotterySave(
        @Body body: LotteryRandomRequest,
    ): BaseResponse<Unit>

    @GET(ApiClient.Lottery.getLotteryRandom)
    suspend fun getLotteryRandom(): BaseResponse<LotteryRandomResponse>

    @GET(ApiClient.Lottery.getLotteryGet)
    suspend fun getLotteryGet(
        @Body body: RefreshRequest,
    ): BaseResponse<LotteryResultResponse>

}
