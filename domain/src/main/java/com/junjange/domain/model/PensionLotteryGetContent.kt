package com.junjange.domain.model

data class PensionLotteryGetContent(
    val round: Int,
    val winningDate: String,
    val pensionLotteryNumbers: List<PensionLotteryNumbers>,
    val winningLotteryNumbers: WinningLotteryNumbers?,
    val winningPensionLotteryBonusNumbers: WinningPensionLotteryBonusNumbers?,
)