package com.junjange.domain.repository

import com.junjange.domain.model.PensionLotteryGet
import com.junjange.domain.model.PensionLotteryHome
import com.junjange.domain.model.PensionLotteryRandom

interface PensionLotteryRepository {

    suspend fun postPensionLotterySave(
        pensionGroup: Int,
        pensionFirstNum: Int,
        pensionSecondNum: Int,
        pensionThirdNum: Int,
        pensionFourthNum: Int,
        pensionFifthNum: Int,
        pensionSixthNum: Int
    ): Result<Unit>

    suspend fun getPensionLotteryRandom(): Result<PensionLotteryRandom>

    suspend fun getPensionLotteryGet(
        page: Int,
        size: Int
    ): Result<PensionLotteryGet>
}