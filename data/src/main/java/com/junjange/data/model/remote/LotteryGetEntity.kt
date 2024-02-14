package com.junjange.data.model.remote

data class LotteryGetEntity(
    val content: List<LotteryGetContentEntity>,
    val last: Boolean,
)