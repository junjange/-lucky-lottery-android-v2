package com.junjange.presentation.ui.my


sealed class MyEffect {
    data object NavigateToEditProfile : MyEffect()
    data object NavigateToUsageTerm : MyEffect()
    data object NavigateToSplash : MyEffect()
    data object NavigateToWithdrawal : MyEffect()
    class NavigateToNotification(
        val lottoNotificationState: Boolean,
        val pensionLottoNotificationState: Boolean
    ) : MyEffect()

}