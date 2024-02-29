package com.junjange.data.repository

import com.junjange.data.datasource.UserDataSource
import com.junjange.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun patchLotteryNotification(notificationStatus: Boolean): Result<Unit> =
        runCatching {
            dataSource.patchLotteryNotification(
                notificationStatus = notificationStatus,
            )
        }

    override suspend fun patchPensionLotteryNotification(notificationStatus: Boolean): Result<Unit> =
        runCatching {
            dataSource.patchPensionLotteryNotification(
                notificationStatus = notificationStatus,
            )
        }

    override suspend fun patchUserProfile(profilePath: String): Result<Unit> =
        runCatching {
            dataSource.patchUserProfile(profilePath = profilePath)
        }
}