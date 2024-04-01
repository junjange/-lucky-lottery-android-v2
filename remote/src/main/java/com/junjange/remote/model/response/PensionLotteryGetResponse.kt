package com.junjange.remote.model.response

import com.junjange.data.model.remote.PensionLotteryGetEntity

data class PensionLotteryGetResponse(
    val content: List<PensionLotteryGetContentResponse>,
    val last: Boolean,
)

internal fun PensionLotteryGetResponse.toData(): PensionLotteryGetEntity =
    PensionLotteryGetEntity(
        content = content.map { it.toData() },
        last = last,
    )
