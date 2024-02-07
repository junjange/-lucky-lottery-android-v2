package com.junjange.remote.model.response

import com.google.gson.annotations.SerializedName

data class LotteryGetResponse(
    @SerializedName("round") val round: Int,
    @SerializedName("winningDate") val winningDate: String,
    @SerializedName("lotteryNumbersResponse") val lotteryNumbersResponse: LotteryNumbersResponse,
    @SerializedName("winningLotteryNumbersResponse") val winningLotteryNumbersResponse: WinningLotteryNumbersResponse,
    @SerializedName("correctNumbers") val correctNumbers: List<Int>,
    @SerializedName("rank") val rank: String
)