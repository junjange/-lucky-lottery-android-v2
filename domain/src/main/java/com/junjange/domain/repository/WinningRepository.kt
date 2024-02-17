package com.junjange.domain.repository

import com.junjange.domain.model.LotteryNumbers
import com.junjange.domain.model.PensionLotteryHome

interface WinningRepository {
    suspend fun getLotteryHome(): Result<LotteryNumbers>

    suspend fun getPensionLotteryHome(): Result<PensionLotteryHome>
}