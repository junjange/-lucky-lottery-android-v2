package com.junjange.domain.model

data class PensionLotteryGet(
    val size: Int,
    val content: List<PensionLotteryGetContent>,
    val number: Int,
    val sort: Sort,
    val numberOfElements: Int,
    val pageable: Pageable,
    val first: Boolean,
    val last: Boolean,
    val empty: Boolean
)











