package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryRandomEntity
import com.junjange.domain.model.LotteryRandom

fun LotteryRandomEntity.toDomain() =
    LotteryRandom(
        firstNum = firstNum,
        secondNum = secondNum,
        thirdNum = thirdNum,
        fourthNum = fourthNum,
        fifthNum = fifthNum,
        sixthNum = sixthNum
    )
