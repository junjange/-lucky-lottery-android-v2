package com.junjange.presentation.ui.my

sealed class MyEffect {
    class NavigateToEditProfile(
        val nickname: String,
        val profilePath: String?,
    ) : MyEffect()

    data object NavigateToUsageTerm : MyEffect()

    data object NavigateToSplash : MyEffect()

    class NavigateToWithdrawal(val oauthProvider: String) : MyEffect()

    class NavigateToNotification(
        val lottoNotificationState: Boolean,
        val pensionLottoNotificationState: Boolean,
    ) : MyEffect()
}
