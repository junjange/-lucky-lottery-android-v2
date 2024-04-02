package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryRandomEntity
import com.junjange.domain.model.PensionLotteryRandom

fun PensionLotteryRandomEntity.toDomain() =
    PensionLotteryRandom(
        pensionRound = pensionRound,
        pensionGroup = pensionGroup,
        pensionFirstNum = pensionFirstNum,
        pensionSecondNum = pensionSecondNum,
        pensionThirdNum = pensionThirdNum,
        pensionFourthNum = pensionFourthNum,
        pensionFifthNum = pensionFifthNum,
        pensionSixthNum = pensionSixthNum,
    )
