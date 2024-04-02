package com.junjange.data.mapper

import com.junjange.data.model.remote.WinningPensionLotteryNumbersEntity
import com.junjange.domain.model.WinningPensionLotteryNumbers

internal fun WinningPensionLotteryNumbersEntity.toDomain() =
    WinningPensionLotteryNumbers(
        lotteryGroup = lotteryGroup,
        winningFirstNum = winningFirstNum,
        winningSecondNum = winningSecondNum,
        winningThirdNum = winningThirdNum,
        winningFourthNum = winningFourthNum,
        winningFifthNum = winningFifthNum,
        winningSixthNum = winningSixthNum,
    )
