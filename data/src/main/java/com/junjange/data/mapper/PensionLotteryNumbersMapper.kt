package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryNumbersEntity
import com.junjange.domain.model.PensionLotteryNumbers

internal fun List<PensionLotteryNumbersEntity>.toDomain() =
    map {
        PensionLotteryNumbers(
            pensionGroup = it.pensionGroup,
            pensionFirstNum = it.pensionFirstNum,
            pensionSecondNum = it.pensionSecondNum,
            pensionThirdNum = it.pensionThirdNum,
            pensionFourthNum = it.pensionFourthNum,
            pensionFifthNum = it.pensionFifthNum,
            pensionSixthNum = it.pensionSixthNum,
            rank = it.rank,
            checkWinningBonus = it.checkWinningBonus,
            correctNumbers = it.correctNumbers,
            bonusCorrectNumbers = it.bonusCorrectNumbers,
        )
    }
