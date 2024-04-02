package com.junjange.data.repository

import com.junjange.data.datasource.NotificationDataSource
import com.junjange.domain.repository.NotificationRepository
import javax.inject.Inject

internal class NotificationRepositoryImpl
    @Inject
    constructor(
        private val dataSource: NotificationDataSource,
    ) : NotificationRepository {
        override suspend fun postNotificationRegisterToken(
            deviceId: String,
            fcmToken: String,
        ): Result<Unit> =
            runCatching {
                dataSource.postNotificationRegisterToken(deviceId = deviceId, fcmToken = fcmToken)
            }
    }
