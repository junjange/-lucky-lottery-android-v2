package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryNumbersEntity
import com.junjange.domain.model.PensionLotteryNumbers

internal fun PensionLotteryNumbersEntity.toDomain() = PensionLotteryNumbers(
    pensionGroup = pensionGroup,
    pensionFirstNum = pensionFirstNum,
    pensionSecondNum = pensionSecondNum,
    pensionThirdNum = pensionThirdNum,
    pensionFourthNum = pensionFourthNum,
    pensionFifthNum = pensionFifthNum,
    pensionSixthNum = pensionSixthNum
)