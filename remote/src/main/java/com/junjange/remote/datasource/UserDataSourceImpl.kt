package com.junjange.remote.datasource

import com.junjange.data.datasource.UserDataSource
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.request.NotificationRequest
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : UserDataSource {

    override suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit> =
        runCatching {
            val body = NotificationRequest(notificationStatus = notificationStatus)
            apiService.patchLotteryNotification(
                body = body,
            ).data
        }

    override suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit> =
        runCatching {
            val body = NotificationRequest(notificationStatus = notificationStatus)
            apiService.patchPensionLotteryNotification(
                body = body,
            ).data
        }
}