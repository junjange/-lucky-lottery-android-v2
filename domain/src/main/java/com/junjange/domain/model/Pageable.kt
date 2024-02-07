package com.junjange.domain.model

data class Pageable(
    val offset: Int,
    val sort: Sort,
    val pageSize: Int,
    val paged: Boolean,
    val pageNumber: Int,
    val unpaged: Boolean
)