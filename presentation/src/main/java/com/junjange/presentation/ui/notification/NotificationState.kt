package com.junjange.presentation.ui.notification

data class NotificationState(
    val isLoading: Boolean = false,
    val isLottoNotificationAvailable: Boolean = false,
    val isPensionLottoNotificationAvailable: Boolean = false,
)
