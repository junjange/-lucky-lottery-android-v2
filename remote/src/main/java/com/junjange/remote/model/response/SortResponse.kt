package com.junjange.remote.model.response

import com.junjange.data.model.remote.SortEntity

data class SortResponse(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean
)

internal fun SortResponse.toData() = SortEntity(
    empty = empty,
    sorted = sorted,
    unsorted = unsorted
)