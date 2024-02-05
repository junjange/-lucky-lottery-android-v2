package com.junjange.remote.datasource

import com.junjange.data.datasource.LotteryDataSource
import com.junjange.data.model.remote.LotteryRandomEntity
import com.junjange.remote.api.LotteryApiService
import com.junjange.remote.model.request.LotteryRandomRequest
import com.junjange.remote.model.response.toData
import javax.inject.Inject

internal class LotteryDataSourceImpl @Inject constructor(
    private val apiService: LotteryApiService,
) : LotteryDataSource {

    override suspend fun postLotterySave(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int
    ): Result<Unit> =
        runCatching {
            val body = LotteryRandomRequest(
                firstNum = firstNum,
                secondNum = secondNum,
                thirdNum = thirdNum,
                fourthNum = fourthNum,
                fifthNum = fifthNum,
                sixthNum = sixthNum
            )
            apiService.postLotterySave(body = body)
        }


    override suspend fun getLotteryRandom(): Result<LotteryRandomEntity> = runCatching {
        apiService.getLotteryRandom().data.toData()
    }
}