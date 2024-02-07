package com.junjange.data.model.remote

data class PensionLotteryGetEntity(
    val size: Int,
    val content: List<PensionLotteryGetContentEntity>,
    val number: Int,
    val sort: SortEntity,
    val numberOfElements: Int,
    val pageable: PageableEntity,
    val first: Boolean,
    val last: Boolean,
    val empty: Boolean
)











