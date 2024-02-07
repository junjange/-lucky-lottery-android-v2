package com.junjange.domain.model

data class PensionLotteryGetContent(
    val round: Int,
    val winningDate: String,
    val rank: String,
    val checkWinningBonus: Boolean,
    val pensionLotteryNumbers: PensionLotteryNumbers,
    val winningLotteryNumbers: WinningLotteryNumbers,
    val winningPensionLotteryBonusNumbers: WinningPensionLotteryBonusNumbers,
    val correctNumbers: List<Boolean>,
    val bonusCorrectNumbers: List<Boolean>
)