package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryRandomNumbersEntity
import com.junjange.domain.model.LotteryRandomNumbers

fun LotteryRandomNumbersEntity.toDomain() = LotteryRandomNumbers(
    round = round,
    winningDate = winningDate,
    firstNum = firstNum,
    secondNum = secondNum,
    thirdNum = thirdNum,
    fourthNum = fourthNum,
    fifthNum = fifthNum,
    sixthNum = sixthNum,
)
