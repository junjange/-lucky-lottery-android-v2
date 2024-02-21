package com.junjange.data.datasource

import com.junjange.data.model.remote.PensionLotteryGetEntity
import com.junjange.data.model.remote.PensionLotteryHomeEntity
import com.junjange.data.model.remote.PensionLotteryRandomEntity

interface PensionLotteryDataSource {

    suspend fun postPensionLotterySave(
        pensionGroup: Int,
        pensionFirstNum: Int,
        pensionSecondNum: Int,
        pensionThirdNum: Int,
        pensionFourthNum: Int,
        pensionFifthNum: Int,
        pensionSixthNum: Int
    ): Result<Unit>

    suspend fun getPensionLotteryRandom(): Result<PensionLotteryRandomEntity>

    suspend fun getPensionLotteryGet(
        page: Int,
        size: Int
    ): Result<PensionLotteryGetEntity>
}