package com.junjange.remote.model.response

import com.junjange.data.model.remote.LotteryGetNumbersEntity

data class LotteryGetNumbersResponse(
    val firstNum: Int,
    val secondNum: Int,
    val thirdNum: Int,
    val fourthNum: Int,
    val fifthNum: Int,
    val sixthNum: Int,
    val correctNumbers: List<Boolean>?,
    val rank: String?
)

internal fun List<LotteryGetNumbersResponse>.toData(): List<LotteryGetNumbersEntity> = map {
    LotteryGetNumbersEntity(
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