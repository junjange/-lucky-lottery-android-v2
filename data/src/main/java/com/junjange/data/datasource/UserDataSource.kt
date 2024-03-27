package com.junjange.data.datasource

interface UserDataSource {
    suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchUserProfile(profilePath: String): Result<Unit>

    suspend fun patchUserNickname(nickname: String): Result<Unit>
}
