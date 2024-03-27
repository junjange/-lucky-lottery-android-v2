package com.junjange.domain.model

data class PensionLotteryNumbers(
    val pensionGroup: Int,
    val pensionFirstNum: Int,
    val pensionSecondNum: Int,
    val pensionThirdNum: Int,
    val pensionFourthNum: Int,
    val pensionFifthNum: Int,
    val pensionSixthNum: Int,
    val rank: String?,
    val checkWinningBonus: Boolean,
    val correctNumbers: List<Boolean>?,
    val bonusCorrectNumbers: List<Boolean>?,
)
