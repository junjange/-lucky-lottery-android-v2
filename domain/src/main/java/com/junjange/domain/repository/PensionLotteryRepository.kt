package com.junjange.domain.repository

import com.junjange.domain.model.PensionLotteryRandom

interface PensionLotteryRepository {

    suspend fun postPensionLotterySave(
        pensionFirstNum: Int,
        pensionSecondNum: Int,
        pensionThirdNum: Int,
        pensionFourthNum: Int,
        pensionFifthNum: Int,
        pensionSixthNum: Int
    ): Result<Unit>

    suspend fun getPensionLotteryRandom(): Result<PensionLotteryRandom>

}