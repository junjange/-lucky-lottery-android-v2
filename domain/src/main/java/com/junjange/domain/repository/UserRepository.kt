package com.junjange.domain.repository

interface UserRepository {
    suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchUserMyInfo(
        profilePath: String,
        nickname: String,
    ): Result<Unit>

}
