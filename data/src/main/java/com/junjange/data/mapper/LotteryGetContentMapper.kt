package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryGetContentEntity
import com.junjange.domain.model.LotteryGetContent

internal fun LotteryGetContentEntity.toDomain() = LotteryGetContent(
    round = round,
    winningDate = winningDate,
    lotteryNumbers = lotteryNumbersEntity.toDomain(),
    winningLotteryNumbers = winningLotteryNumbersEntity?.toDomain(),
)