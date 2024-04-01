package com.junjange.remote.model.response

import com.junjange.data.model.remote.WinningPensionLotteryBonusNumbersEntity

data class WinningPensionLotteryBonusNumbersResponse(
    val bonusFirstNum: Int,
    val bonusSecondNum: Int,
    val bonusThirdNum: Int,
    val bonusFourthNum: Int,
    val bonusFifthNum: Int,
    val bonusSixthNum: Int,
)

internal fun WinningPensionLotteryBonusNumbersResponse.toData() =
    WinningPensionLotteryBonusNumbersEntity(
        bonusFirstNum = bonusFirstNum,
        bonusSecondNum = bonusSecondNum,
        bonusThirdNum = bonusThirdNum,
        bonusFourthNum = bonusFourthNum,
        bonusFifthNum = bonusFifthNum,
        bonusSixthNum = bonusSixthNum,
    )
