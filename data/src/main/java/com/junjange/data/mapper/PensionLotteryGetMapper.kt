package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryGetEntity
import com.junjange.domain.model.PensionLotteryGet


internal fun PensionLotteryGetEntity.toDomain() =
    PensionLotteryGet(
        size = size,
        content = content.map { it.toDomain() },
        number = number,
        sort = sort.toDomain(),
        numberOfElements = numberOfElements,
        pageable = pageable.toDomain(),
        first = first,
        last = last,
        empty = empty
    )










