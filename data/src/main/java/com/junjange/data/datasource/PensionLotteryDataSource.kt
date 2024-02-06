package com.junjange.data.datasource

import com.junjange.data.model.remote.PensionLotteryRandomEntity

interface PensionLotteryDataSource {

    suspend fun postPensionLotterySave(
        pensionFirstNum: Int,
        pensionSecondNum: Int,
        pensionThirdNum: Int,
        pensionFourthNum: Int,
        pensionFifthNum: Int,
        pensionSixthNum: Int
    ): Result<Unit>

    suspend fun getPensionLotteryRandom(): Result<PensionLotteryRandomEntity>

}