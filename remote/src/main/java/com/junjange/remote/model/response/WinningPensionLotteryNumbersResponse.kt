package com.junjange.remote.model.response

import com.junjange.data.model.remote.WinningPensionLotteryNumbersEntity

data class WinningPensionLotteryNumbersResponse(
    val lotteryGroup: Int,
    val winningFirstNum: Int,
    val winningSecondNum: Int,
    val winningThirdNum: Int,
    val winningFourthNum: Int,
    val winningFifthNum: Int,
    val winningSixthNum: Int
)

internal fun WinningPensionLotteryNumbersResponse.toData() =
    WinningPensionLotteryNumbersEntity(
        lotteryGroup = lotteryGroup,
        winningFirstNum = winningFirstNum,
        winningSecondNum = winningSecondNum,
        winningThirdNum = winningThirdNum,
        winningFourthNum = winningFourthNum,
        winningFifthNum = winningFifthNum,
        winningSixthNum = winningSixthNum
    )