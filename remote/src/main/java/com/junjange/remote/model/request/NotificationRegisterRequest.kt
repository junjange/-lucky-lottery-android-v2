package com.junjange.remote.model.request

data class NotificationRegisterRequest(
    val deviceId: String,
    val fcmToken: String
)
