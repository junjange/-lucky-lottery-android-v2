package com.junjange.remote.model.response

import com.junjange.data.model.remote.IsRegisteredEntity


data class IsRegisteredResponse(
    val isRegistered: String
)

fun IsRegisteredResponse.toData() = IsRegisteredEntity(isRegistered = isRegistered)
