package com.junjange.remote.model.response

import com.junjange.data.model.remote.PensionLotteryGetEntity

data class PensionLotteryGetResponse(
    val size: Int,
    val content: List<PensionLotteryGetContentResponse>,
    val number: Int,
    val sort: SortResponse,
    val numberOfElements: Int,
    val pageable: PageableResponse,
    val first: Boolean,
    val last: Boolean,
    val empty: Boolean
)

internal fun PensionLotteryGetResponse.toData(): PensionLotteryGetEntity =
    PensionLotteryGetEntity(
        size = size,
        content = content.map { it.toData() },
        number = number,
        sort = sort.toData(),
        numberOfElements = numberOfElements,
        pageable = pageable.toData(),
        first = first,
        last = last,
        empty = empty
    )










