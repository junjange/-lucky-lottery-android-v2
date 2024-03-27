package com.junjange.presentation.ui.withdrawal

data class WithdrawalState(
    val step: Int = 1,
    val isWithdrawalDialogShowing: Boolean = false,
)
