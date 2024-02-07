package com.junjange.data.mapper

import com.junjange.data.model.remote.WinningLotteryNumbersEntity
import com.junjange.domain.model.WinningLotteryNumbers


internal fun WinningLotteryNumbersEntity.toDomain() =
    WinningLotteryNumbers(
        lotteryGroup = lotteryGroup,
        winningFirstNum = winningFirstNum,
        winningSecondNum = winningSecondNum,
        winningThirdNum = winningThirdNum,
        winningFourthNum = winningFourthNum,
        winningFifthNum = winningFifthNum,
        winningSixthNum = winningSixthNum
    )