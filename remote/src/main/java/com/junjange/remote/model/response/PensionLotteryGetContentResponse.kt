package com.junjange.remote.model.response

import com.junjange.data.model.remote.PensionLotteryGetContentEntity

data class PensionLotteryGetContentResponse(
    val round: Int,
    val winningDate: String,
    val rank: String,
    val checkWinningBonus: Boolean,
    val pensionLotteryNumbersResponse: PensionLotteryNumbersResponse,
    val winningLotteryNumbersResponse: WinningLotteryNumbersResponse,
    val winningPensionLotteryBonusNumbersResponse: WinningPensionLotteryBonusNumbersResponse,
    val correctNumbers: List<Boolean>,
    val bonusCorrectNumbers: List<Boolean>
)

internal fun PensionLotteryGetContentResponse.toData() = PensionLotteryGetContentEntity(
    round = round,
    winningDate = winningDate,
    rank = rank,
    checkWinningBonus = checkWinningBonus,
    pensionLotteryNumbersEntity = pensionLotteryNumbersResponse.toData(),
    winningLotteryNumbersEntity = winningLotteryNumbersResponse.toData(),
    winningPensionLotteryBonusNumbersEntity = winningPensionLotteryBonusNumbersResponse.toData(),
    correctNumbers = correctNumbers,
    bonusCorrectNumbers = bonusCorrectNumbers

)