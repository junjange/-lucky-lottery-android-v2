package com.junjange.remote.datasource

import com.junjange.data.datasource.PensionLotteryDataSource
import com.junjange.data.model.remote.PensionLotteryRandomEntity
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.request.PensionLotteryRandomRequest
import com.junjange.remote.model.response.toData
import javax.inject.Inject

internal class PensionLotteryDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : PensionLotteryDataSource {

    override suspend fun postPensionLotterySave(
        pensionFirstNum: Int,
        pensionSecondNum: Int,
        pensionThirdNum: Int,
        pensionFourthNum: Int,
        pensionFifthNum: Int,
        pensionSixthNum: Int
    ): Result<Unit> = runCatching {
        val body = PensionLotteryRandomRequest(
            pensionFirstNum = pensionFirstNum,
            pensionSecondNum = pensionSecondNum,
            pensionThirdNum = pensionThirdNum,
            pensionFourthNum = pensionFourthNum,
            pensionFifthNum = pensionFifthNum,
            pensionSixthNum = pensionSixthNum
        )
        apiService.postPensionLotterySave(body = body)

    }

    override suspend fun getPensionLotteryRandom(): Result<PensionLotteryRandomEntity> =
        runCatching {
            apiService.getPensionLotteryRandom().data.toData()
        }
}