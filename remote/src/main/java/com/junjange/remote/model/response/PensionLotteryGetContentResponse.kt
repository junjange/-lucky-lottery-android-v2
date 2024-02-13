package com.junjange.remote.model.response

import com.junjange.data.model.remote.PensionLotteryGetContentEntity

data class PensionLotteryGetContentResponse(
    val round: Int,
    val winningDate: String,
    val pensionLotteryNumbersResponse: List<PensionLotteryNumbersResponse>,
    val winningLotteryNumbersResponse: WinningLotteryNumbersResponse?,
    val winningPensionLotteryBonusNumbersResponse: WinningPensionLotteryBonusNumbersResponse?,
)

internal fun PensionLotteryGetContentResponse.toData() = PensionLotteryGetContentEntity(
    round = round,
    winningDate = winningDate,
    pensionLotteryNumbersEntity = pensionLotteryNumbersResponse.toData(),
    winningLotteryNumbersEntity = winningLotteryNumbersResponse?.toData(),
    winningPensionLotteryBonusNumbersEntity = winningPensionLotteryBonusNumbersResponse?.toData(),
)