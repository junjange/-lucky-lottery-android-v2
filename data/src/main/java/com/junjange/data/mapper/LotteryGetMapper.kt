package com.junjange.data.mapper

import com.junjange.data.model.remote.LotteryGetEntity
import com.junjange.domain.model.LotteryGet


internal fun LotteryGetEntity.toDomain() = LotteryGet(
    content = content.map { it.toDomain() },
    last = last,
)