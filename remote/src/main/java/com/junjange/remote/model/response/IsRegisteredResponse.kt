package com.junjange.remote.model.response

import com.junjange.data.model.remote.IsRegisteredEntity

data class IsRegisteredResponse(
    val isRegistered: Boolean,
)

fun IsRegisteredResponse.toData() = IsRegisteredEntity(isRegistered = isRegistered)
