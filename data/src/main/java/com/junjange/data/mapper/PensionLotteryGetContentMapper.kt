package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryGetContentEntity
import com.junjange.domain.model.PensionLotteryGetContent

internal fun PensionLotteryGetContentEntity.toDomain() =
    PensionLotteryGetContent(
        round = round,
        winningDate = winningDate,
        checkWinningBonus = checkWinningBonus,
        pensionLotteryNumbers = pensionLotteryNumbersEntity.toDomain(),
        winningPensionLotteryNumbers = winningPensionLotteryNumbersEntity?.toDomain(),
        winningPensionLotteryBonusNumbers = winningPensionLotteryBonusNumbersEntity?.toDomain(),
    )
