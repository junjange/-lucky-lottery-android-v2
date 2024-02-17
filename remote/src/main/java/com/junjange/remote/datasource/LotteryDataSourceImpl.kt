package com.junjange.remote.datasource

import com.junjange.data.datasource.LotteryDataSource
import com.junjange.data.model.remote.LotteryGetEntity
import com.junjange.data.model.remote.LotteryNumbersEntity
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.request.LotteryRandomRequest
import com.junjange.remote.model.response.toData
import javax.inject.Inject

internal class LotteryDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : LotteryDataSource {

    override suspend fun getLotteryGet(page: Int, size: Int): Result<LotteryGetEntity> =
        runCatching {
            apiService.getLotteryGet(page = page, size = size).data.toData()
        }

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


    override suspend fun getLotteryRandom(): Result<LotteryNumbersEntity> = runCatching {
        apiService.getLotteryRandom().data.toData()
    }

    override suspend fun getLotteryHome(): Result<LotteryNumbersEntity> = runCatching {
        apiService.getLotteryHome().data.toData()
    }
}