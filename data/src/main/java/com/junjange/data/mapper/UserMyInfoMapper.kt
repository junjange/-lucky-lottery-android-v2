package com.junjange.data.mapper

import com.junjange.data.model.remote.UserMyInfoEntity
import com.junjange.domain.model.UserMyInfo

internal fun UserMyInfoEntity.toDomain() =
    UserMyInfo(
        id = id,
        nickname = nickname,
        oauthProvider = oauthProvider,
        email = email,
        profilePath = profilePath,
        lotteryNotificationStatus = lotteryNotificationStatus,
        pensionLotteryNotificationStatus = pensionLotteryNotificationStatus,
    )
