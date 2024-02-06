package com.junjange.remote.api

import com.junjange.remote.model.BaseResponse
import com.junjange.remote.model.request.PensionLotteryRandomRequest
import com.junjange.remote.model.response.PensionLotteryRandomResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


internal interface PensionLotteryApiService {

    @POST(ApiClient.PensionLottery.postPensionLotterySave)
    suspend fun postPensionLotterySave(@Body body: PensionLotteryRandomRequest): BaseResponse<Unit>

    @GET(ApiClient.PensionLottery.getPensionLotteryRandom)
    suspend fun getPensionLotteryRandom(): BaseResponse<PensionLotteryRandomResponse>

}
