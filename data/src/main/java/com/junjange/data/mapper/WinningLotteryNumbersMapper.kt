package com.junjange.data.mapper

import com.junjange.data.model.remote.WinningLotteryNumbersEntity
import com.junjange.domain.model.WinningLotteryNumbers

internal fun WinningLotteryNumbersEntity.toDomain() =
    WinningLotteryNumbers(
        bonusNum = bonusNum,
        firstNum = firstNum,
        secondNum = secondNum,
        thirdNum = thirdNum,
        fourthNum = fourthNum,
        fifthNum = fifthNum,
        sixthNum = sixthNum,
    )
