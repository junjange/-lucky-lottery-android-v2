package com.junjange.data.mapper

import com.junjange.data.model.remote.WinningPensionLotteryBonusNumbersEntity
import com.junjange.domain.model.WinningPensionLotteryBonusNumbers

internal fun WinningPensionLotteryBonusNumbersEntity.toDomain() =
    WinningPensionLotteryBonusNumbers(
        bonusFirstNum = bonusFirstNum,
        bonusSecondNum = bonusSecondNum,
        bonusThirdNum = bonusThirdNum,
        bonusFourthNum = bonusFourthNum,
        bonusFifthNum = bonusFifthNum,
        bonusSixthNum = bonusSixthNum,
    )
