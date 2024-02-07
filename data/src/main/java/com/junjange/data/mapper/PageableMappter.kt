package com.junjange.data.mapper

import com.junjange.data.model.remote.PageableEntity
import com.junjange.domain.model.Pageable

internal fun PageableEntity.toDomain() =
    Pageable(
        offset = offset,
        sort = sort.toDomain(),
        pageSize = pageSize,
        paged = paged,
        pageNumber = pageNumber,
        unpaged = unpaged
    )