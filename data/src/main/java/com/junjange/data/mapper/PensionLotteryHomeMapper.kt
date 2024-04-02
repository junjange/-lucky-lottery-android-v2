package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryHomeEntity
import com.junjange.domain.model.PensionLotteryHome

internal fun PensionLotteryHomeEntity.toDomain() =
    PensionLotteryHome(
        round = round,
        winningDate = winningDate,
        lotteryGroup = lotteryGroup,
        winningFirstNum = winningFirstNum,
        winningSecondNum = winningSecondNum,
        winningThirdNum = winningThirdNum,
        winningFourthNum = winningFourthNum,
        winningFifthNum = winningFifthNum,
        winningSixthNum = winningSixthNum,
        bonusFirstNum = bonusFirstNum,
        bonusSecondNum = bonusSecondNum,
        bonusThirdNum = bonusThirdNum,
        bonusFourthNum = bonusFourthNum,
        bonusFifthNum = bonusFifthNum,
        bonusSixthNum = bonusSixthNum,
    )
