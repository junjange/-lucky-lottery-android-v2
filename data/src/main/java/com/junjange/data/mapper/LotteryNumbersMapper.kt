package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryNumbersEntity
import com.junjange.domain.model.LotteryNumbers

internal fun List<LotteryNumbersEntity>.toDomain() = map {
    LotteryNumbers(
        firstNum = it.firstNum,
        secondNum = it.secondNum,
        thirdNum = it.thirdNum,
        fourthNum = it.fourthNum,
        fifthNum = it.fifthNum,
        sixthNum = it.sixthNum,
        correctNumbers = it.correctNumbers,
        rank = it.rank
    )
}