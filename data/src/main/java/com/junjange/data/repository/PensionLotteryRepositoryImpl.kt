package com.junjange.data.repository

import com.junjange.data.datasource.PensionLotteryDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.PensionLotteryGet
import com.junjange.domain.model.PensionLotteryRandom
import com.junjange.domain.repository.PensionLotteryRepository
import javax.inject.Inject

internal class PensionLotteryRepositoryImpl
    @Inject
    constructor(
        private val dataSource: PensionLotteryDataSource,
    ) : PensionLotteryRepository {
        override suspend fun postPensionLotterySave(
            pensionGroup: Int,
            pensionFirstNum: Int,
            pensionSecondNum: Int,
            pensionThirdNum: Int,
            pensionFourthNum: Int,
            pensionFifthNum: Int,
            pensionSixthNum: Int,
        ): Result<Unit> =
            dataSource.postPensionLotterySave(
                pensionGroup = pensionGroup,
                pensionFirstNum = pensionFirstNum,
                pensionSecondNum = pensionSecondNum,
                pensionThirdNum = pensionThirdNum,
                pensionFourthNum = pensionFourthNum,
                pensionFifthNum = pensionFifthNum,
                pensionSixthNum = pensionSixthNum,
            )

        override suspend fun getPensionLotteryRandom(): Result<PensionLotteryRandom> =
            dataSource.getPensionLotteryRandom().mapCatching { it.toDomain() }

        override suspend fun getPensionLotteryGet(
            page: Int,
            size: Int,
        ): Result<PensionLotteryGet> =
            dataSource.getPensionLotteryGet(
                page = page,
                size = size,
            ).mapCatching { it.toDomain() }
    }
