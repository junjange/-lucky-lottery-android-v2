package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryNumbersEntity
import com.junjange.domain.model.LotteryNumbers

fun LotteryNumbersEntity.toDomain() =
    LotteryNumbers(
        firstNum = firstNum,
        secondNum = secondNum,
        thirdNum = thirdNum,
        fourthNum = fourthNum,
        fifthNum = fifthNum,
        sixthNum = sixthNum
    )
