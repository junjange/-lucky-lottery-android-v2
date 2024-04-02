package com.junjange.data.model.remote

data class LotteryNumbersEntity(
    val round: Int,
    val winningDate: String,
    val firstNum: Int,
    val secondNum: Int,
    val thirdNum: Int,
    val fourthNum: Int,
    val fifthNum: Int,
    val sixthNum: Int,
    val bonusNum: Int,
)
