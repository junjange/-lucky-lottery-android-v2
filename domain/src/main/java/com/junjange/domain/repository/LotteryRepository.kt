package com.junjange.domain.repository

import com.junjange.domain.model.LotteryRandom

interface LotteryRepository {
    suspend fun postLotterySave(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int
    ): Result<Unit>

    suspend fun getLotteryRandom(): Result<LotteryRandom>

}