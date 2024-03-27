package com.junjange.domain.usecase

import com.junjange.domain.repository.UserRepository
import javax.inject.Inject

class PatchLotteryNotificationUseCase
    @Inject
    constructor(
        private val repository: UserRepository,
    ) {
        suspend operator fun invoke(notificationStatus: Boolean): Result<Unit> =
            repository.patchLotteryNotification(notificationStatus = notificationStatus)
    }
