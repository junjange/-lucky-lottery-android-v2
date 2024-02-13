package com.junjange.remote.model.response

import com.junjange.data.model.remote.WinningLotteryNumbersEntity

data class WinningLotteryNumbersResponse(
    val lotteryGroup: Int,
    val winningFirstNum: Int,
    val winningSecondNum: Int,
    val winningThirdNum: Int,
    val winningFourthNum: Int,
    val winningFifthNum: Int,
    val winningSixthNum: Int
)

internal fun WinningLotteryNumbersResponse.toData() =
    WinningLotteryNumbersEntity(
        lotteryGroup = lotteryGroup,
        winningFirstNum = winningFirstNum,
        winningSecondNum = winningSecondNum,
        winningThirdNum = winningThirdNum,
        winningFourthNum = winningFourthNum,
        winningFifthNum = winningFifthNum,
        winningSixthNum = winningSixthNum
    )