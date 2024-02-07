package com.junjange.remote.model.response

import com.junjange.data.model.remote.PensionLotteryNumbersEntity

data class PensionLotteryNumbersResponse(
    val pensionGroup: Int,
    val pensionFirstNum: Int,
    val pensionSecondNum: Int,
    val pensionThirdNum: Int,
    val pensionFourthNum: Int,
    val pensionFifthNum: Int,
    val pensionSixthNum: Int
)

internal fun PensionLotteryNumbersResponse.toData() = PensionLotteryNumbersEntity(
    pensionGroup = pensionGroup,
    pensionFirstNum = pensionFirstNum,
    pensionSecondNum = pensionSecondNum,
    pensionThirdNum = pensionThirdNum,
    pensionFourthNum = pensionFourthNum,
    pensionFifthNum = pensionFifthNum,
    pensionSixthNum = pensionSixthNum
)