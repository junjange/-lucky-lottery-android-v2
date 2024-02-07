package com.junjange.remote.model.response

import com.junjange.data.model.remote.PageableEntity

data class PageableResponse(
    val offset: Int,
    val sort: SortResponse,
    val pageSize: Int,
    val paged: Boolean,
    val pageNumber: Int,
    val unpaged: Boolean
)

internal fun PageableResponse.toData() =
    PageableEntity(
        offset = offset,
        sort = sort.toData(),
        pageSize = pageSize,
        paged = paged,
        pageNumber = pageNumber,
        unpaged = unpaged
    )