package com.junjange.data.datasource

import com.junjange.data.model.remote.UserMyInfoEntity

interface UserDataSource {
    suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchUserMyInfo(
        profilePath: String?,
        nickname: String,
    ): Result<Unit>

    suspend fun getUserMyInfo(): Result<UserMyInfoEntity>
}
