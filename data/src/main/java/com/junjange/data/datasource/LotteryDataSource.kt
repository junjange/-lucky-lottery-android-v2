package com.junjange.data.datasource

import com.junjange.data.model.remote.LotteryGetEntity
import com.junjange.data.model.remote.LotteryNumbersEntity

interface LotteryDataSource {

    suspend fun getLotteryGet(page: Int, size: Int): Result<LotteryGetEntity>

    suspend fun postLotterySave(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int
    ): Result<Unit>

    suspend fun getLotteryRandom(): Result<LotteryNumbersEntity>

    suspend fun getLotteryHome(): Result<LotteryNumbersEntity>

}