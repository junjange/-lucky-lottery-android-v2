package com.junjange.data.datasource

import com.junjange.data.model.remote.LotteryNumbersEntity
import com.junjange.data.model.remote.PensionLotteryHomeEntity

interface WinningDataSource {
    suspend fun getWinningLotteryHome(): Result<LotteryNumbersEntity>

    suspend fun getWinningPensionLotteryHome(): Result<PensionLotteryHomeEntity>
}
