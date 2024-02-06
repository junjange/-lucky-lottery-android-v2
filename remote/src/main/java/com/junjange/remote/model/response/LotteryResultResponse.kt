package com.junjange.remote.model.response

import com.google.gson.annotations.SerializedName

data class LotteryResultResponse(
    @SerializedName("round") val round: Int,
    @SerializedName("winningDate") val winningDate: String,
    @SerializedName("lotteryNumbersResponse") val lotteryNumbersResponse: LotteryNumbersResponse,
    @SerializedName("winningLotteryNumbersResponse") val winningLotteryNumbersResponse: WinningLotteryNumbersResponse,
    @SerializedName("correctNumbers") val correctNumbers: List<Int>,
    @SerializedName("rank") val rank: String
)

data class LotteryNumbersResponse(
    @SerializedName("firstNum") val firstNum: Int,
    @SerializedName("secondNum") val secondNum: Int,
    @SerializedName("thirdNum") val thirdNum: Int,
    @SerializedName("fourthNum") val fourthNum: Int,
    @SerializedName("fifthNum") val fifthNum: Int,
    @SerializedName("sixthNum") val sixthNum: Int
)

data class WinningLotteryNumbersResponse(
    @SerializedName("firstNum") val firstNum: Int,
    @SerializedName("secondNum") val secondNum: Int,
    @SerializedName("thirdNum") val thirdNum: Int,
    @SerializedName("fourthNum") val fourthNum: Int,
    @SerializedName("fifthNum") val fifthNum: Int,
    @SerializedName("sixthNum") val sixthNum: Int,
    @SerializedName("bonusNum") val bonusNum: Int
)
