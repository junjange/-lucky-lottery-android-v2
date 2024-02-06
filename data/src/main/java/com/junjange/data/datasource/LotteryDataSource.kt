package com.junjange.data.datasource

import com.junjange.data.model.remote.LotteryRandomEntity

interface LotteryDataSource {

    suspend fun postLotterySave(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int
    ): Result<Unit>

    suspend fun getLotteryRandom(): Result<LotteryRandomEntity>

}