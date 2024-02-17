package com.junjange.remote.model.response

import com.junjange.data.model.remote.LotteryGetEntity


data class LotteryGetResponse(
    val content: List<LotteryGetContentResponse>,
    val last: Boolean,
)

internal fun LotteryGetResponse.toData() = LotteryGetEntity(
    content = content.toData(),
    last = last
)