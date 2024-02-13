package com.junjange.data.mapper

import com.junjange.data.model.remote.PensionLotteryGetEntity
import com.junjange.domain.model.PensionLotteryGet


internal fun PensionLotteryGetEntity.toDomain() =
    PensionLotteryGet(
        content = content.map { it.toDomain() },
        last = last,
    )










