package com.junjange.data.datasource

interface UserDataSource {
    suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit>

    suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit>


    suspend fun getUserMyInfo(): Result<UserMyInfoEntity>
}
