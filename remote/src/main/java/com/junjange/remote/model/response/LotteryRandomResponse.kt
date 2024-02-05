package com.junjange.remote.model.response

import com.junjange.data.model.remote.LotteryRandomEntity

data class LotteryRandomResponse(
    val firstNum: Int,
    val secondNum: Int,
    val thirdNum: Int,
    val fourthNum: Int,
    val fifthNum: Int,
    val sixthNum: Int
)

internal fun LotteryRandomResponse.toData(): LotteryRandomEntity =
    LotteryRandomEntity(
        firstNum = firstNum,
        secondNum = secondNum,
        thirdNum = thirdNum,
        fourthNum = fourthNum,
        fifthNum = fifthNum,
        sixthNum = sixthNum
    )