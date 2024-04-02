package com.junjange.data.repository

import com.junjange.data.datasource.WinningDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.LotteryNumbers
import com.junjange.domain.model.PensionLotteryHome
import com.junjange.domain.repository.WinningRepository
import javax.inject.Inject

internal class WinningRepositoryImpl
    @Inject
    constructor(
        private val dataSource: WinningDataSource,
    ) : WinningRepository {
        override suspend fun getLotteryHome(): Result<LotteryNumbers> = dataSource.getWinningLotteryHome().mapCatching { it.toDomain() }

        override suspend fun getPensionLotteryHome(): Result<PensionLotteryHome> =
            dataSource.getWinningPensionLotteryHome().mapCatching { it.toDomain() }
    }
