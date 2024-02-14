package com.junjange.data.model.remote


data class LotteryGetContentEntity(
    val round: Int,
    val winningDate: String,
    val lotteryNumbersEntity: List<LotteryNumbersEntity>,
    val winningLotteryNumbersEntity: WinningLotteryNumbersEntity?,
)
