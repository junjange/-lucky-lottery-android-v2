package com.junjange.domain.repository


interface UserRepository {
    suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchUserProfile(profilePath: String): Result<Unit>
}