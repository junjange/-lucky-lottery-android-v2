package com.junjange.remote.model

data class BaseResponse<T>(
    val status: Int,
    val data: T,
    val success: Boolean,
    val timeStamp: String,
)
