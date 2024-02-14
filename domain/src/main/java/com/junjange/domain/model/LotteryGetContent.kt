package com.junjange.domain.model


data class LotteryGetContent(
    val round: Int,
    val winningDate: String,
    val lotteryNumbers: List<LotteryNumbers>,
    val winningLotteryNumbers: WinningLotteryNumbers?,
)
