package com.junjange.presentation.ui.withdrawal

import com.junjange.presentation.ui.my.OauthProvider

data class WithdrawalState(
    val step: Int = 1,
    val isWithdrawalDialogShowing: Boolean = false,
    val oauthProvider: OauthProvider = OauthProvider.GOOGLE,
)
