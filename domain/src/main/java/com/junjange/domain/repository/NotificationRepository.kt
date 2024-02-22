package com.junjange.domain.repository

import com.junjange.domain.model.IsRegistered
import com.junjange.domain.model.JwtToken

interface NotificationRepository {
    suspend fun postNotificationRegisterToken(
        deviceId: String,
        fcmToken: String,
    ): Result<Unit>
}