package com.junjange.data.model.remote

data class WinningLotteryNumbersEntity(
    val lotteryGroup: Int,
    val winningFirstNum: Int,
    val winningSecondNum: Int,
    val winningThirdNum: Int,
    val winningFourthNum: Int,
    val winningFifthNum: Int,
    val winningSixthNum: Int
)