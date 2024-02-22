package com.junjange.remote.datasource

import com.junjange.data.datasource.NotificationDataSource
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.request.NotificationRegisterRequest
import javax.inject.Inject

internal class NotificationDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : NotificationDataSource {

    override suspend fun postNotificationRegisterToken(
        deviceId: String,
        fcmToken: String,
    ): Result<Unit> =
        runCatching {
            val body = NotificationRegisterRequest(deviceId = deviceId, fcmToken = fcmToken)
            apiService.postNotificationRegisterToken(body = body).data
        }
}