package com.junjange.remote.model.response

import com.google.gson.annotations.SerializedName
import com.junjange.data.model.remote.LotteryGetContentEntity


data class LotteryGetContentResponse(
    val round: Int,
    val winningDate: String,
    @SerializedName("lotteryResponses") val lotteryNumbersResponse: List<LotteryNumbersResponse>,
    val winningLotteryNumbersResponse: WinningLotteryNumbersResponse?,
)


internal fun List<LotteryGetContentResponse>.toData() = map {
    LotteryGetContentEntity(
        round = it.round,
        winningDate = it.winningDate,
        lotteryNumbersEntity = it.lotteryNumbersResponse.toData(),
        winningLotteryNumbersEntity = it.winningLotteryNumbersResponse?.toData()
    )
}