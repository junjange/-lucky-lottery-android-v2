package com.junjange.presentation.ui.my

data class MyState(
    val isLoading: Boolean = false,
    val isNotificationAvailable: Boolean = false,
    val nickname: String = "",
    val profilePath: String? = null,
    val oauthProvider: String = "",
    val lotteryNotificationStatus: Boolean = false,
    val pensionLotteryNotificationStatus: Boolean = false,
)
