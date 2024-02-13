package com.junjange.remote.model.response

import com.junjange.data.model.remote.LotteryNumbersEntity

data class LotteryNumbersResponse(
    val firstNum: Int,
    val secondNum: Int,
    val thirdNum: Int,
    val fourthNum: Int,
    val fifthNum: Int,
    val sixthNum: Int
)

internal fun LotteryNumbersResponse.toData(): LotteryNumbersEntity =
    LotteryNumbersEntity(
        firstNum = firstNum,
        secondNum = secondNum,
        thirdNum = thirdNum,
        fourthNum = fourthNum,
        fifthNum = fifthNum,
        sixthNum = sixthNum
    )