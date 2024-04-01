package com.junjange.data.repository

import com.junjange.data.datasource.UserDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.UserMyInfo
import com.junjange.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl
    @Inject
    constructor(
        private val dataSource: UserDataSource,
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

        override suspend fun patchUserMyInfo(
            profilePath: String,
            nickname: String,
        ): Result<Unit> =
            runCatching {
                dataSource.patchUserMyInfo(profilePath = profilePath, nickname = nickname)
            }

        override suspend fun getUserMyInfo(): Result<UserMyInfo> = dataSource.getUserMyInfo().mapCatching { it.toDomain() }
    }
