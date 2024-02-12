package com.junjange.data.model.remote

data class PensionLotteryGetContentEntity(
    val round: Int,
    val winningDate: String,
    val pensionLotteryNumbersEntity: List<PensionLotteryNumbersEntity>,
    val winningLotteryNumbersEntity: WinningLotteryNumbersEntity,
    val winningPensionLotteryBonusNumbersEntity: WinningPensionLotteryBonusNumbersEntity,
)