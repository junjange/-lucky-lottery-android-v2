package com.junjange.domain.repository

import com.junjange.domain.model.LotteryGet
import com.junjange.domain.model.LotteryNumbers

interface LotteryRepository {

    suspend fun getLotteryGet(page: Int, size: Int): Result<LotteryGet>

    suspend fun postLotterySave(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int
    ): Result<Unit>

    suspend fun getLotteryRandom(): Result<LotteryNumbers>

    suspend fun getLotteryHome(): Result<LotteryNumbers>

}