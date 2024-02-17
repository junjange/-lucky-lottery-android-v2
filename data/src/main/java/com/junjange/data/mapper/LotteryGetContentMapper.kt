package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryGetContentEntity
import com.junjange.domain.model.LotteryGetContent

internal fun LotteryGetContentEntity.toDomain() = LotteryGetContent(
    round = round,
    winningDate = winningDate,
    lotteryGetNumbers = lotteryGetNumbersEntity.toDomain(),
    winningLotteryNumbers = winningLotteryNumbersEntity?.toDomain(),
)