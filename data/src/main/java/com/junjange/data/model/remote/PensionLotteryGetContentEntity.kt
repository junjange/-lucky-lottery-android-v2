package com.junjange.data.model.remote

data class PensionLotteryGetContentEntity(
    val round: Int,
    val winningDate: String,
    val rank: String,
    val checkWinningBonus: Boolean,
    val pensionLotteryNumbersEntity: PensionLotteryNumbersEntity,
    val winningLotteryNumbersEntity: WinningLotteryNumbersEntity,
    val winningPensionLotteryBonusNumbersEntity: WinningPensionLotteryBonusNumbersEntity,
    val correctNumbers: List<Boolean>,
    val bonusCorrectNumbers: List<Boolean>
)