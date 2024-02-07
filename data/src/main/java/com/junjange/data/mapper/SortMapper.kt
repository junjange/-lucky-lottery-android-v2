package com.junjange.data.mapper

import com.junjange.data.model.remote.SortEntity
import com.junjange.domain.model.Sort


internal fun SortEntity.toDomain() = Sort(
    empty = empty,
    sorted = sorted,
    unsorted = unsorted
)